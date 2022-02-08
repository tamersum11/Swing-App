package appmanager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dbmanager.IDBManager;
import dbmanager.QueryFactory;
import uimanager.AdminMainWindow;
import uimanager.MainWindow;

public class AdminLoginManager implements ILoginManager{
    private HashMap<String, String> queryMap;
    private ResultSet adminInfo;
    private String adminPassword;
    private JFrame messageBox;

    public AdminLoginManager(String adminName, String adminPassword) {
        queryMap = new HashMap<String, String>();
        this.adminPassword = adminPassword;
        queryMap.put("Name", adminName);

        messageBox = new JFrame();
    }
    
    @Override
    public void setLoginManager() {
        IDBManager selectAdmin = QueryFactory.getQuery("selectwhere");
        selectAdmin.setTable("Admins");
        selectAdmin.setQueryMap(queryMap);
        selectAdmin.setQueryBool("AND");
        selectAdmin.setQuery();

        adminInfo = selectAdmin.getResult();
        checkQuery();
    }

    private void checkQuery() {
        try {
            if(adminInfo != null) {
                if(adminInfo.getString("Password").equals(adminPassword)) {
                    JOptionPane.showMessageDialog(messageBox, "Welcome " + adminInfo.getString("Name"), "Success Login", JOptionPane.INFORMATION_MESSAGE);
                    userLog();
                    showUserMainWindow();
                    exitMainWindow();
                } else {
                    incorrectLog();
                    JOptionPane.showMessageDialog(messageBox, "Password is Wrong!!!", "Login Error", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(messageBox, "Email is Wrong!!!", "Login Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(messageBox, "Email is Wrong!!!", "Login Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void incorrectLog() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        HashMap<String, String> insertQueryMap = new HashMap<String, String>();
        try {
            insertQueryMap.put("AdminId", adminInfo.getString("id"));
            insertQueryMap.put("Process", "Incorrect Log");
            insertQueryMap.put("ProcessDate", formatter.format(date));
            insertUserProcessesTable(insertQueryMap);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(messageBox, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void userLog() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        HashMap<String, String> insertQueryMap = new HashMap<String, String>();
        try {
            insertQueryMap.put("AdminId", adminInfo.getString("id"));
            insertQueryMap.put("Process", "Log");
            insertQueryMap.put("ProcessDate", formatter.format(date));
            insertUserProcessesTable(insertQueryMap);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(messageBox, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void insertUserProcessesTable(HashMap<String, String> insertQueryMap ) {
        IDBManager insertUserProcesses = QueryFactory.getQuery("insert");
        insertUserProcesses.setTable("AdminProcesses");
        insertUserProcesses.setQueryMap(insertQueryMap);
        insertUserProcesses.setQuery();
        insertUserProcesses.getResult();
    }

    private void showUserMainWindow() {
        AdminMainWindow adminMainWindow = AdminMainWindow.getWindow();
        adminMainWindow.setAdminInfo(adminInfo);
        adminMainWindow.show();
    }

    private void exitMainWindow() {
        MainWindow window = MainWindow.getWindow();
        window.exit();
    }
}

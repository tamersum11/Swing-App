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
import uimanager.MainWindow;
import uimanager.UserMainWindow;

public class UserLoginManager implements ILoginManager {
    private HashMap<String, String> queryMap;
    private ResultSet userInfo;
    private String userPassword;
    private JFrame messageBox;

    public UserLoginManager(String userEmail, String userPassword) {
        queryMap = new HashMap<String, String>();
        this.userPassword = userPassword;
        queryMap.put("Email", userEmail);

        messageBox = new JFrame();
    }

    @Override
    public void setLoginManager() {
        IDBManager selectUser = QueryFactory.getQuery("selectwhere");
        selectUser.setTable("Users");
        selectUser.setQueryMap(queryMap);
        selectUser.setQueryBool("AND");
        selectUser.setQuery();

        userInfo = selectUser.getResult();
        checkQuery();
    }

    private void checkQuery() {
        try {
            if(userInfo != null) {
                if(userInfo.getString("Password").equals(userPassword)) {
                    JOptionPane.showMessageDialog(messageBox, "Welcome " + userInfo.getString("Name"), "Success Login", JOptionPane.INFORMATION_MESSAGE);
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
            insertQueryMap.put("UserId", userInfo.getString("id"));
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
            insertQueryMap.put("UserId", userInfo.getString("id"));
            insertQueryMap.put("Process", "Log");
            insertQueryMap.put("ProcessDate", formatter.format(date));
            insertUserProcessesTable(insertQueryMap);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(messageBox, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void insertUserProcessesTable(HashMap<String, String> insertQueryMap ) {
        IDBManager insertUserProcesses = QueryFactory.getQuery("insert");
        insertUserProcesses.setTable("UserProcesses");
        insertUserProcesses.setQueryMap(insertQueryMap);
        insertUserProcesses.setQuery();
        insertUserProcesses.getResult();
    }

    private void showUserMainWindow() {
        UserMainWindow userMainWindow = UserMainWindow.getWindow();
        userMainWindow.setUserInfo(userInfo);
        userMainWindow.show();
    }

    private void exitMainWindow() {
        MainWindow window = MainWindow.getWindow();
        window.exit();
    }
}

package appmanager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dbmanager.IDBManager;
import dbmanager.QueryFactory;

public class UserRegisterManager {
    private final String name;
    private final String email;
    private final String job;
    private final String password;

    private HashMap<String, String> insertQueryMap;
    private JFrame messageBox;

    private UserRegisterManager(UserBuilder builder) {
        insertQueryMap = new HashMap<String, String>();

        this.name = builder.name;
        this.email = builder.email;
        this.job = builder.job;
        this.password = builder.password;

        messageBox = new JFrame();
    }

    public void register() {
        insertQueryMap.put("Name", name);
        insertQueryMap.put("Email", email);
        insertQueryMap.put("Job", job);
        insertQueryMap.put("Password", password);
        insertQueryMap.put("Confirmation", "false");

        IDBManager insertUserRegisterations = QueryFactory.getQuery("insert");
        insertUserRegisterations.setTable("UserRegisterations");
        insertUserRegisterations.setQueryMap(insertQueryMap);
        insertUserRegisterations.setQuery();

        try {
            insertUserRegisterations.getResult();
            JOptionPane.showMessageDialog(messageBox, "Your registration request is send.", "Registration Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(messageBox, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static class UserBuilder
    {
        private final String email;
        private final String password;
        private final String passwordCommit;
        private String name;
        private String job;
        
        private HashMap<String, String> queryMap;
        private JFrame messageBox;

        public UserBuilder(String email, String password, String passwordCommit) {
            queryMap = new HashMap<String, String>();
            messageBox = new JFrame();

            this.email = email;
            this.password = password;
            this.passwordCommit = passwordCommit;

            queryMap.put("Email", email);
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder job(String job) {
            this.job = job;
            return this;
        }

        public UserRegisterManager build() {
            if(validateUser() && checkPassword()) {
                UserRegisterManager user =  new UserRegisterManager(this);
                return user;
            } else {return null;}
        }

        private boolean validateUser() {
            return checkInUsers() && checkInUserRegisterations();
        }

        private boolean checkInUsers() {
            boolean result = true;

            IDBManager selectUser = QueryFactory.getQuery("selectwhere");
            selectUser.setTable("Users");
            selectUser.setQueryMap(queryMap);
            selectUser.setQueryBool("AND");
            selectUser.setQuery();

            ResultSet userInfo = selectUser.getResult();

            try {
                if(userInfo != null) {
                    if(userInfo.getString("Email").equals(email)) {
                        JOptionPane.showMessageDialog(messageBox, "User already exists!!!", "Registeration Error", JOptionPane.WARNING_MESSAGE);
                        result = false;
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(messageBox, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
            }

            return result;
        }

        private boolean checkInUserRegisterations() {
            boolean result = true;

            IDBManager selectUser = QueryFactory.getQuery("selectwhere");
            selectUser.setTable("UserRegisterations");
            selectUser.setQueryMap(queryMap);
            selectUser.setQueryBool("AND");
            selectUser.setQuery();

            ResultSet userInfo = selectUser.getResult();

            try {
                if(userInfo != null) {
                    if(userInfo.getString("Email").equals(email)) {
                        JOptionPane.showMessageDialog(messageBox, "User already send registration request!!!", "Registeration Error", JOptionPane.WARNING_MESSAGE);
                        result = false;
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(messageBox, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
            }

            return result;
        }

        private boolean checkPassword() {
            boolean result = false;

            if(password.length() < 8) {
                JOptionPane.showMessageDialog(messageBox, "Password cannot be less than 8 characters!!!", "Registeration Error", JOptionPane.WARNING_MESSAGE);
            } else if(!password.equals(passwordCommit)) {
                JOptionPane.showMessageDialog(messageBox, "Commit Password is not equals to password!!!", "Registeration Error", JOptionPane.WARNING_MESSAGE);
            } else {result = true;}

            return result;
        }
    }
}

package dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DBConnector {
    private static DBConnector dbConnector;

    private String jdbcUrl = "jdbc:sqlite:../Swing-App/BankAppDB.db";
    private Connection connection;
    private Statement statement;
    private JFrame messageBox;

    private DBConnector() {
        messageBox = new JFrame();
        try {
            connection = DriverManager.getConnection(jdbcUrl);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(messageBox, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(messageBox, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public ResultSet getResultSet(String sqlQuery) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(messageBox, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
        }

        return result;
    }

    public void execQuery(String sqlQuery) {
        try {
            statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(messageBox, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static DBConnector getInstance() {
        if(dbConnector == null)
        {
            dbConnector = new DBConnector();
        }

        return dbConnector;
    }
}

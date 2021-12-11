package dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    private static DBConnector dbConnector;

    private String jdbcUrl = "jdbc:sqlite:../BankApp/BankAppDB.db";
    private Connection connection;
    private Statement statement;

    private DBConnector() throws SQLException {
        connection = DriverManager.getConnection(jdbcUrl);
        statement = connection.createStatement();
    }

    public ResultSet getResultSet(String sqlQuery) throws SQLException {
        return statement.executeQuery(sqlQuery);
    }

    public static DBConnector getInstance() throws SQLException {
        if(dbConnector == null)
        {
            dbConnector = new DBConnector();
        }

        return dbConnector;
    }
}

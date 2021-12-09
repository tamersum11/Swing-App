package dbmanager;

public class DBConnector {
    private static DBConnector dbConnector;

    private DBConnector() {
        
    }

    public DBConnector getInstance() {
        if(dbConnector == null)
        {
            dbConnector = new DBConnector();
        }

        return dbConnector;
    }
}

package dbmanager;

import java.sql.ResultSet;
import java.util.HashMap;

public class SelectAll implements IDBManager{
    private String query;
    private String table;
    private DBConnector dbconn;


    public SelectAll() {
        dbconn = DBConnector.getInstance();
    }

    @Override
    public void setTable(String table) {
        this.table = table;
    }
    
    @Override
    public void setColumn(String column) {
        column = null;
    }

    @Override
    public void setItem(String item) {
        item = null;
    }

    @Override
    public void setQueryMap(HashMap<String, String> queryMap) {
        queryMap = null;
    }

    @Override
    public void setQuery() {
        query = "SELECT * FROM " + table;
    }

    @Override
    public ResultSet getResult() {
        return dbconn.getResultSet(query);
    }
}

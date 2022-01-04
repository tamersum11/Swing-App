package dbmanager;

import java.sql.ResultSet;
import java.util.HashMap;

public class Insert implements IDBManager {
    private String query;
    private String table;
    private HashMap<String, String> queryMap;
    private DBConnector dbconn;

    public Insert() {
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
        this.queryMap = queryMap;
    }

    @Override
    public void setQuery() {
        query = "INSERT INTO " + table + " (";
        for(String column : queryMap.keySet()){
            query += column + ", ";
        }
        query = query.substring(0, query.length() - 2) + ") VALUES (";
        for(String values : queryMap.values()){
            query += "'" + values + "', ";
        }
        query = query.substring(0, query.length() - 2) + ")";
    }

    @Override
    public ResultSet getResult() {
        return dbconn.getResultSet(query);
    }
}

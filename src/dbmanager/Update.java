package dbmanager;

import java.sql.ResultSet;
import java.util.HashMap;

public class Update implements IDBManager {
    private String query;
    private String table;
    private String column;
    private String item;
    private DBConnector dbconn;
    HashMap<String, String> queryMap;

    public Update() {
        dbconn = DBConnector.getInstance();
    }

    @Override
    public void setTable(String table) {
        this.table = table;
    }

    @Override
    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public void setQueryMap(HashMap<String, String> queryMap) {
        this.queryMap = queryMap;
    }
    
    @Override
    public void setQuery() {
        query = "UPDATE " + table + " SET ";
        for(String key : queryMap.keySet()){
            query += key + " = '" + queryMap.get(key) + "', ";
        }
        query = query.substring(0, query.length() - 2) + " WHERE " + column + " = '" + item + "'";
    }

    @Override
    public ResultSet getResult() {
        return dbconn.getResultSet(query);
    }
}

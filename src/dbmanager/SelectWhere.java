package dbmanager;

import java.sql.ResultSet;
import java.util.HashMap;

public class SelectWhere implements IDBManager{
    private String query;
    private String table;
    private String queryBool;
    private HashMap<String, String> queryMap;
    private DBConnector dbconn;

    public SelectWhere() {
        dbconn = DBConnector.getInstance();
    }

    public void setQueryBool(String queryBool) {
        this.queryBool = queryBool;
    }

    private void setQueryOR() {
        query = "SELECT * FROM " + table + " WHERE ";
        for(String item : queryMap.keySet()){
            query += item + " = '" + queryMap.get(item) + "' OR ";
        }
        query = query.substring(0, query.length() - 4);
    }

    private void setQueryAND() {
        query = "SELECT * FROM " + table + " WHERE ";
        for(String item : queryMap.keySet()){
            query += item + " = '" + queryMap.get(item) + "' AND ";
        }
        query = query.substring(0, query.length() - 5);
    }

    @Override
    public void setTable(String table) {
        this.table = table;
    }

    @Override
    public void setQueryMap(HashMap<String, String> queryMap) {
        this.queryMap = queryMap;
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
    public void setQuery() {
        if(queryBool.equalsIgnoreCase("OR")){
            setQueryOR();
        }else if(queryBool.equalsIgnoreCase("AND")){
            setQueryAND();
        } else {
            setQueryOR();
        }
    }

    @Override
    public ResultSet getResult() {
        return dbconn.getResultSet(query);
    } 
}

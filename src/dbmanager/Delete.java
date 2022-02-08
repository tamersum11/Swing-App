package dbmanager;

import java.sql.ResultSet;
import java.util.HashMap;

public class Delete implements IDBManager {
    private String query;
    private String table;
    private String column;
    private String item;
    private DBConnector dbconn;

    public Delete() {
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
        queryMap = null;
    }

    @Override
    public void setQueryBool(String queryBool) {
        queryBool = null;
    }

    @Override
    public void setQuery() {
        query = "DELETE FROM " + table + " WHERE " + column + "= '" + item + "'";
    }

    @Override
    public ResultSet getResult() {
        return dbconn.getResultSet(query);
    }
}

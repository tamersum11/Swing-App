package dbmanager;

import java.sql.ResultSet;
import java.util.HashMap;

public interface IDBManager {
    void setTable(String table);
    void setColumn(String column);
    void setItem(String item);
    void setQueryMap(HashMap<String, String> queryMap);
    void setQueryBool(String queryBool);
    void setQuery();
    ResultSet getResult();
}

package dbmanager;

public class QueryFactory {
    public static IDBManager getQuery(String queryType) {
        if(queryType == null){
            return null;
        }		
        if(queryType.equalsIgnoreCase("SELECTALL")){
            return new SelectAll();
            
        } else if(queryType.equalsIgnoreCase("SELECTWHERE")){
            return new SelectWhere();
            
        } else if(queryType.equalsIgnoreCase("INSERT")){
            return new Insert();

        } else if(queryType.equalsIgnoreCase("UPDATE")){
            return new Update();

        } else if(queryType.equalsIgnoreCase("DELETE")){
            return new Delete();
        
        }
         
         return null;
    }
}

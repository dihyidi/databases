package mvc.model.dao;

import java.util.Arrays;

public class SqlQuery {
    public static String SelectAll(String tableName) {
        return String.format("select * from %s", tableName);
    }
    public static String SelectById(String tableName) {
        return String.format("select * from %s where id=?", tableName);
    }

    public static String Add(String tableName, String[] paramNames) {
        StringBuilder tmp = new StringBuilder("insert into ");
        tmp.append(tableName);
        tmp.append(" (");
        for (int i = 0; i < paramNames.length; i++) {
            tmp.append(paramNames[i]);
            if(i != paramNames.length-1){
                tmp.append(", ");
            }
        }
        tmp.append(") values (");
        for (int i = 0; i < paramNames.length; i++) {
            tmp.append("?");
            if(i != paramNames.length-1){
                tmp.append(",");
            }
            else {
                tmp.append(")");
            }
        }

        return tmp.toString();
    }
    public static String Update(String tableName, String[] paramNames){
        StringBuilder tmp = new StringBuilder("update ");
        tmp.append(tableName);
        tmp.append(" set ");
        for (int i = 0; i < paramNames.length; i++) {
            tmp.append(paramNames[i]);
            tmp.append("=?");
            if(i != paramNames.length-1){
                tmp.append(", ");
            }
        }
        tmp.append(" where id=?");

        return tmp.toString();
    }
    public static String Delete(String tableName) {
        return String.format("delete from %s where id=?", tableName);
    };
}

package mvc.model.managers;

import mvc.model.beans.Specialization;
import mvc.model.dao.SqlQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecializationManager extends ManagerImpl<Specialization> {

    public SpecializationManager() {
        super("specialization");
    }

    @Override
    protected Specialization getBeanInstance(ResultSet res) {
        var spec = new Specialization();
        try {
            spec.setId(res.getInt("id"));
            spec.setName(res.getString("name"));
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return spec;
    }

    @Override
    protected String getSqlAdd() {
        return SqlQuery.Add(tableName, new String[]{"name"});
    }

    @Override
    protected void setPrepStmtParamsForAdd(PreparedStatement prepStmt, Specialization bean) {
        try {
            prepStmt.setString(1, bean.getName());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    protected void setPrepStmtParamsForUpdate(PreparedStatement prepStmt, Specialization bean) {
        try {
            prepStmt.setString(1, bean.getName());
            prepStmt.setInt(2, bean.getId());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    protected String getSqlUpdate() {
        return SqlQuery.Update(tableName, new String[]{"name"});
    }

    @Override
    protected String getSqlDelete() {
        return SqlQuery.Delete(tableName);
    }
}

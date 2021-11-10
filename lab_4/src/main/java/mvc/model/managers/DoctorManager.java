package mvc.model.managers;

import mvc.model.beans.Doctor;
import mvc.model.dao.SqlQuery;

import java.sql.*;

public class DoctorManager extends ManagerImpl<Doctor> {
    public DoctorManager(){
        super("doctor");
    }

    @Override
    protected Doctor getBeanInstance(ResultSet res) {
        var doc = new Doctor();
        try {
            doc.setId(res.getInt("id"));
            doc.setName(res.getString("name"));
            doc.setExperienceYrs(res.getInt("experience_yrs"));
            doc.setSpecializationId(res.getInt("specialization_id"));
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return doc;
    }

    @Override
    protected String getSqlAdd() {
        return SqlQuery.Add(tableName, new String[]{"name", "experience_yrs", "specialization_id"});
    }

    @Override
    protected void setPrepStmtParamsForAdd(PreparedStatement prepStmt, Doctor bean) {
        try {
            prepStmt.setString(1, bean.getName());
            prepStmt.setInt(2, bean.getExperienceYrs());
            prepStmt.setInt(3, bean.getSpecializationId());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected String getSqlUpdate() {
        return SqlQuery.Update(tableName, new String[]{"name", "experience_yrs", "specialization_id"});
    }

    @Override
    protected void setPrepStmtParamsForUpdate(PreparedStatement prepStmt, Doctor bean) {
        try {
            prepStmt.setString(1, bean.getName());
            prepStmt.setInt(2, bean.getExperienceYrs());
            prepStmt.setInt(3, bean.getSpecializationId());
            prepStmt.setInt(4, bean.getId());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected String getSqlDelete() {
        return SqlQuery.Delete(tableName);
    }
}

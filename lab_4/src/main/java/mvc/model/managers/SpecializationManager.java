package mvc.model.managers;

import mvc.model.beans.Specialization;
import mvc.model.dao.DatabaseCloser;
import mvc.model.dao.DatabaseConnector;
import mvc.model.dao.SqlQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecializationManager implements Manager<Specialization> {
    private static final Connection conn = DatabaseConnector.getConnection();
    private static final String table = "specialization";

    @Override
    public List<Specialization> getBeans() {
        List<Specialization> specializationList = new ArrayList<>();

        Statement stmt = null;
        ResultSet res = null;

        String sql = SqlQuery.SelectAll(table);

        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            res = stmt.executeQuery(sql);
            while(res.next()) {
                Specialization spec = new Specialization();
                spec.setId(res.getInt("id"));
                spec.setName(res.getString("name"));
                specializationList.add(spec);
            }
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " +e.getErrorCode());
            System.err.println("SQL state: " +e.getSQLState());
        } finally {
            DatabaseCloser.close(res, stmt);
        }

        return specializationList;
    }

    @Override
    public Specialization getBeanById(int id) {
        Specialization spec = null;

        PreparedStatement prepStmt = null;
        ResultSet res = null;

        String sql = SqlQuery.SelectById(table);

        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setInt(1, id);
            res = prepStmt.executeQuery();

            if(res.next()) {
                spec = new Specialization();
                spec.setId(id);
                spec.setName(res.getString("name"));
            }

        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " +e.getErrorCode());
            System.err.println("SQL state: " +e.getSQLState());
        } finally {
            DatabaseCloser.close(res, prepStmt);
        }
        return spec;
    }

    @Override
    public boolean addBean(Specialization bean) {
        boolean isAdded = false;
        int affectedRows = 0;
        PreparedStatement prepStmt = null;

        if(bean != null) {
            String sql = SqlQuery.Add(table, new String[]{"name"});
            try {
                prepStmt = conn.prepareStatement(sql);
                prepStmt.setString(1, "spec1");
                affectedRows = prepStmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error message: " + e.getMessage());
                System.err.println("Error code: " +e.getErrorCode());
                System.err.println("SQL state: " +e.getSQLState());
            } finally {
                DatabaseCloser.close(prepStmt);
            }
            isAdded = (affectedRows != 0);
        }
        return isAdded;
    }

    @Override
    public boolean updateBean(int id, Specialization bean) {
        boolean isUpdated = false;
        int affectedRows = 0;
        PreparedStatement prepStmt = null;

        if(bean != null) {
            String sql = SqlQuery.Update(table, new String[]{"name"});
            try {
                prepStmt = conn.prepareStatement(sql);
                prepStmt.setString(1, "spec2");
                prepStmt.setInt(2, 2);
                affectedRows = prepStmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error message: " + e.getMessage());
                System.err.println("Error code: " +e.getErrorCode());
                System.err.println("SQL state: " +e.getSQLState());
            } finally {
                DatabaseCloser.close(prepStmt);
            }
            isUpdated = (affectedRows != 0);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteBean(int id) {
        boolean isDeleted = false;
        int affectedRows = 0;
        PreparedStatement prepStmt = null;

        if(id != 0) {
            String sql = SqlQuery.Delete(table);
            try {
                prepStmt = conn.prepareStatement(sql);
                prepStmt.setInt(1, id);
                affectedRows = prepStmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error message: " + e.getMessage());
                System.err.println("Error code: " +e.getErrorCode());
                System.err.println("SQL state: " +e.getSQLState());
            } finally {
                DatabaseCloser.close(prepStmt);
            }
            isDeleted = (affectedRows != 0);
        }
        return isDeleted;
    }
}

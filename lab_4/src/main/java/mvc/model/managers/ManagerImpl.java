package mvc.model.managers;

import mvc.model.dao.DatabaseCloser;
import mvc.model.dao.DatabaseConnector;
import mvc.model.dao.SqlQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ManagerImpl<T> implements Manager<T>{
    private static final Connection conn = DatabaseConnector.getConnection();
    protected String tableName;

    protected ManagerImpl(String tableName){
        this.tableName = tableName;
    }

    protected abstract T getBeanInstance(ResultSet res);

    @Override
    public List<T> getBeans() {
        List<T> beanList = new ArrayList<>();

        Statement stmt = null;
        ResultSet res = null;

        String sql = SqlQuery.SelectAll(tableName);

        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            res = stmt.executeQuery(sql);
            while(res.next()) {
                T bean = getBeanInstance(res);
                beanList.add(bean);
            }
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " +e.getErrorCode());
            System.err.println("SQL state: " +e.getSQLState());
        } finally {
            DatabaseCloser.close(res, stmt);
        }

        return beanList;
    }

    @Override
    public T getBeanById(int id) {
        T bean = null;

        PreparedStatement prepStmt = null;
        ResultSet res = null;

        String sql = SqlQuery.SelectById(tableName);

        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setInt(1, id);
            res = prepStmt.executeQuery();

            if(res.next()) {
                bean = getBeanInstance(res);
            }

        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " +e.getErrorCode());
            System.err.println("SQL state: " +e.getSQLState());
        } finally {
            DatabaseCloser.close(res, prepStmt);
        }
        return bean;
    }

    protected abstract String getSqlAdd();
    protected abstract void setPrepStmtParamsForAdd(PreparedStatement prepStmt, T bean);

    @Override
    public boolean addBean(T bean) {
        boolean isAdded = false;
        int affectedRows = 0;
        PreparedStatement prepStmt = null;

        if(bean != null) {
            String sql = getSqlAdd();
            isAdded = modifyBeanOnAdd(affectedRows, prepStmt, bean, sql);
        }
        return isAdded;
    }

    protected abstract String getSqlUpdate();
    protected abstract void setPrepStmtParamsForUpdate(PreparedStatement prepStmt, T bean);

    @Override
    public boolean updateBean(int id, T bean) {
        boolean isUpdated = false;
        int affectedRows = 0;
        PreparedStatement prepStmt = null;

        if(bean != null) {
            String sql = getSqlUpdate();
            isUpdated = modifyBeanOnUpdate(affectedRows, prepStmt, bean, sql);
        }
        return isUpdated;
    }

    private boolean modifyBeanOnAdd(int affectedRows, PreparedStatement prepStmt, T bean, String sql) {
        boolean isUpdated;
        try {
            prepStmt = conn.prepareStatement(sql);
            setPrepStmtParamsForAdd(prepStmt, bean);
            affectedRows = prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " +e.getErrorCode());
            System.err.println("SQL state: " +e.getSQLState());
        } finally {
            DatabaseCloser.close(prepStmt);
        }
        isUpdated = (affectedRows != 0);
        return isUpdated;
    }

    private boolean modifyBeanOnUpdate(int affectedRows, PreparedStatement prepStmt, T bean, String sql) {
        boolean isUpdated;
        try {
            prepStmt = conn.prepareStatement(sql);
            setPrepStmtParamsForUpdate(prepStmt, bean);
            affectedRows = prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " +e.getErrorCode());
            System.err.println("SQL state: " +e.getSQLState());
        } finally {
            DatabaseCloser.close(prepStmt);
        }
        isUpdated = (affectedRows != 0);
        return isUpdated;
    }

    protected abstract String getSqlDelete();

    @Override
    public boolean deleteBean(int id) {
        boolean isDeleted = false;
        int affectedRows = 0;
        PreparedStatement prepStmt = null;

        if(id != 0) {
            String sql = getSqlDelete();
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

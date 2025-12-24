package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.proj4.bean.EmployeeBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.util.JDBCDataSource;

public class EmployeeModel {

    /* ===================== NEXT PK ===================== */
    public Integer nextPk() throws DatabaseException {

        Connection conn = null;
        int pk = 0;

        try {
            conn = JDBCDataSource.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement("select max(id) from st_employee");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                pk = rs.getInt(1);
            }
            rs.close();
            pstmt.close();

        } catch (Exception e) {
            throw new DatabaseException("Exception in getting Employee PK");
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
        return pk + 1;
    }

    /* ===================== ADD ===================== */
    public long add(EmployeeBean bean) throws ApplicationException {

        Connection conn = null;
        int pk = 0;

        try {
            pk = nextPk();
            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(
                "insert into st_employee values (?, ?, ?, ?, ?, ?, ?)");

            pstmt.setInt(1, pk);
            pstmt.setString(2, bean.getName());
            pstmt.setString(3, bean.getEmail());
            pstmt.setString(4, bean.getPhone());
            pstmt.setString(5, bean.getSalary());
            pstmt.setString(6, bean.getDepartment());
            pstmt.setDate(7, new java.sql.Date(bean.getJoinDate().getTime()));

            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                throw new ApplicationException("Add rollback exception");
            }
            throw new ApplicationException("Exception in adding Employee");
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
        return pk;
    }

    /* ===================== UPDATE ===================== */
    public void update(EmployeeBean bean) throws ApplicationException {

        Connection conn = null;

        try {
            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(
                "update st_employee set name=?, email=?, phone=?, salary=?, department=?, joinDate=? where id=?");

            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getEmail());
            pstmt.setString(3, bean.getPhone());
            pstmt.setString(4, bean.getSalary());
            pstmt.setString(5, bean.getDepartment());
            pstmt.setDate(6, new java.sql.Date(bean.getJoinDate().getTime()));
            pstmt.setLong(7, bean.getId());

            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                throw new ApplicationException("Update rollback exception");
            }
            throw new ApplicationException("Exception in updating Employee");
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
    }

    /* ===================== DELETE ===================== */
    public void delete(EmployeeBean bean) throws ApplicationException {

        Connection conn = null;

        try {
            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement pstmt =
                    conn.prepareStatement("delete from st_employee where id=?");
            pstmt.setLong(1, bean.getId());
            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                throw new ApplicationException("Delete rollback exception");
            }
            throw new ApplicationException("Exception in deleting Employee");
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
    }

    /* ===================== FIND BY PK ===================== */
    public EmployeeBean findByPk(long pk) throws ApplicationException {

        EmployeeBean bean = null;
        Connection conn = null;

        try {
            conn = JDBCDataSource.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement("select * from st_employee where id=?");
            pstmt.setLong(1, pk);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                bean = new EmployeeBean();
                bean.setId(rs.getLong(1));
                bean.setName(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setPhone(rs.getString(4));
                bean.setSalary(rs.getString(5));
                bean.setDepartment(rs.getString(6));
                bean.setJoinDate(rs.getDate(7));
            }
            rs.close();
            pstmt.close();

        } catch (Exception e) {
            throw new ApplicationException("Exception in finding Employee by PK");
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
        return bean;
    }

    /* ===================== LIST ===================== */
    public List<EmployeeBean> list() throws ApplicationException {
        return search(null, 0, 0);
    }
    
    /* ===================== SEARCH ===================== */
    public List<EmployeeBean> search(EmployeeBean bean, int pageNo, int pageSize)
            throws ApplicationException {

        Connection conn = null;
        List<EmployeeBean> list = new ArrayList<>();

        StringBuffer sql = new StringBuffer("SELECT * FROM st_employee WHERE 1=1");

        if (bean != null) {
            if (bean.getName() != null && bean.getName().length() > 0) {
                sql.append(" AND name LIKE '" + bean.getName() + "%'");
            }
            if (bean.getDepartment() != null && bean.getDepartment().length() > 0) {
                sql.append(" AND department LIKE '" + bean.getDepartment() + "%'");
            }
        }

        if (pageSize > 0) {
            pageNo = (pageNo - 1) * pageSize;
            sql.append(" LIMIT " + pageNo + "," + pageSize);
        }

        try {
            conn = JDBCDataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                EmployeeBean e = new EmployeeBean();
                e.setId(rs.getLong(1));
                e.setName(rs.getString(2));
                e.setEmail(rs.getString(3));
                e.setPhone(rs.getString(4));
                e.setSalary(rs.getString(5));
                e.setDepartment(rs.getString(6));
                e.setJoinDate(rs.getDate(7));
                list.add(e);
            }
            rs.close();
            pstmt.close();

        } catch (Exception e) {
            throw new ApplicationException("Exception in Employee search");
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
        return list;
    }

   
}

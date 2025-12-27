package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.proj4.bean.EmployeeBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

/**
 * EmployeeModel handles all database operations related to Employee entity.
 * 
 * @author Mehreen
 * @version 1.0
 */
public class EmployeeModel {

	// ---------- Next PK ----------
	public Integer nextPk() throws DatabaseException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_employee");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new DatabaseException("Exception : Exception in getting Employee PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;
	}

	// ---------- Find By Email (Duplicate Check) ----------
	public EmployeeBean findByEmail(String email) throws ApplicationException {

		EmployeeBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
					"select * from  st_employee where email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new EmployeeBean();
				bean.setId(rs.getLong("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in find Employee by Email");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}

	// ---------- Add ----------
	public long add(EmployeeBean bean)
			throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		EmployeeBean existBean = findByEmail(bean.getEmail());
		if (existBean != null) {
			throw new DuplicateRecordException("Email already exists");
		}

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"insert into st_employee values (?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getPhone());
			pstmt.setString(5, bean.getSalary());
			pstmt.setString(6, bean.getGender());
			pstmt.setString(7, bean.getDepartment());
			pstmt.setDate(8, new java.sql.Date(bean.getJoinDate().getTime()));
			pstmt.setString(9, bean.getCreatedBy());
			pstmt.setString(10, bean.getModifiedBy());
			pstmt.setTimestamp(11, bean.getCreatedDatetime());
			pstmt.setTimestamp(12, bean.getModifiedDatetime());

			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add Employee");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	// ---------- Update ----------
	public void update(EmployeeBean bean)
			throws ApplicationException, DuplicateRecordException {

		Connection conn = null;

		EmployeeBean existBean = findByEmail(bean.getEmail());
		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Email already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_employee set name=?, email=?, phone=?, salary=?, gender=?, department=?, joinDate=?, "
							+ "created_by=?, modified_by=?, created_datetime=?, modified_datetime=? where id=?");

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getPhone());
			pstmt.setString(4, bean.getSalary());
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getDepartment());
			pstmt.setDate(7, new java.sql.Date(bean.getJoinDate().getTime()));
			pstmt.setString(8, bean.getCreatedBy());
			pstmt.setString(9, bean.getModifiedBy());
			pstmt.setTimestamp(10, bean.getCreatedDatetime());
			pstmt.setTimestamp(11, bean.getModifiedDatetime());
			pstmt.setLong(12, bean.getId());

			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Update rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in update Employee");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	// ---------- Delete ----------
	public void delete(EmployeeBean bean) throws ApplicationException {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"delete from st_employee where id = ?");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();

			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in delete Employee");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	// ---------- Find By PK ----------
	public EmployeeBean findByPk(long pk) throws ApplicationException {

		EmployeeBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
					"select * from st_employee where id = ?");
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new EmployeeBean();
				bean.setId(rs.getLong("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				bean.setSalary(rs.getString("salary"));
				bean.setGender(rs.getString("gender"));
				bean.setDepartment(rs.getString("department"));
				bean.setJoinDate(rs.getDate("joinDate"));
				bean.setCreatedBy(rs.getString("created_by"));
				bean.setModifiedBy(rs.getString("modified_by"));
				bean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
				bean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in find Employee by PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}

	// ---------- Search ----------
	public List<EmployeeBean> search(EmployeeBean bean, int pageNo, int pageSize)
			throws ApplicationException {

		Connection conn = null;
		List<EmployeeBean> list = new ArrayList<>();

		StringBuffer sql = new StringBuffer("select * from st_employee where 1=1");

		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" AND name LIKE '" + bean.getName() + "%'");
			}
			if (bean.getEmail() != null && bean.getEmail().length() > 0) {
				sql.append(" AND email LIKE '" + bean.getEmail() + "%'");
			}
			if (bean.getDepartment() != null && bean.getDepartment().length() > 0) {
				sql.append(" AND department LIKE '" + bean.getDepartment() + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" LIMIT " + pageNo + ", " + pageSize);
		}

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeBean e = new EmployeeBean();
				e.setId(rs.getLong("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setSalary(rs.getString("salary"));
				e.setGender(rs.getString("gender"));
				e.setDepartment(rs.getString("department"));
				e.setJoinDate(rs.getDate("joinDate"));
				list.add(e);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in search Employee");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}
}

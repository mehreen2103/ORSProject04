package in.co.rays.proj4.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Singleton class to manage database connections using C3P0 connection pool.
 * 
 * <p>
 * Provides methods to get a database connection and close resources safely.
 * </p>
 * 
 * <p>
 * @author mehre <br>
 * Version: 1.0
 * </p>
 */
public final class JDBCDataSource {

    /** Singleton instance of JDBCDataSource */
    private static JDBCDataSource jds = null;

    /** C3P0 connection pool */
    private ComboPooledDataSource cpds = null;

    /** Resource bundle to read database configuration */
    private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.proj4.bundle.system");

    /**
     * Private constructor to initialize the C3P0 connection pool using properties
     * from the resource bundle.
     */
    private JDBCDataSource() {
        try {
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass(rb.getString("driver"));
            cpds.setJdbcUrl(rb.getString("url"));
            cpds.setUser(rb.getString("username"));
            cpds.setPassword(rb.getString("password"));
            cpds.setInitialPoolSize(Integer.parseInt((rb.getString("initialpoolsize"))));
            cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireincrement")));
            cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpoolsize")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the singleton instance of JDBCDataSource.
     * 
     * @return JDBCDataSource instance
     */
    public static JDBCDataSource getInstance() {
        if (jds == null) {
            jds = new JDBCDataSource();
        }
        return jds;
    }

    /**
     * Returns a database connection from the connection pool.
     * 
     * @return Connection object, or null if unable to connect
     */
    public static Connection getConnection() {
        try {
            return getInstance().cpds.getConnection();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Closes the given Connection, Statement, and ResultSet objects safely.
     * 
     * @param conn Connection to close
     * @param stmt Statement to close
     * @param rs   ResultSet to close
     */
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the given Connection and Statement objects safely.
     * 
     * @param conn Connection to close
     * @param stmt Statement to close
     */
    public static void closeConnection(Connection conn, Statement stmt) {
        closeConnection(conn, stmt, null);
    }

    /**
     * Closes only the given Connection safely.
     * 
     * @param conn Connection to close
     */
    public static void closeConnection(Connection conn) {
        closeConnection(conn, null);
    }
}

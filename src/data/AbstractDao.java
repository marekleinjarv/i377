package data;

import java.sql.*;

import org.apache.commons.dbutils.DbUtils;

public abstract class AbstractDao {

	public static final String DB_URL = "jdbc:hsqldb:file:${user.home}/data/marekleinjarv/db;shutdown=true;hsqldb.lock_file=false";

	private Connection conn;
	protected PreparedStatement pst;
	protected Statement stmt;
	protected ResultSet rset;

	static {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Connection getConnection() {
		try {
			conn = DriverManager.getConnection(DB_URL, "sa", "");
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	protected void closeResources() {
		DbUtils.closeQuietly(rset);
		DbUtils.closeQuietly(pst);
		DbUtils.closeQuietly(stmt);
		DbUtils.closeQuietly(conn);
	}

	protected void executeQuery(String queryString) {
		try {
			stmt = getConnection().createStatement();
			stmt.executeUpdate(queryString);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			closeResources();
		}
	}

}

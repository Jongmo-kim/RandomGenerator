package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","getithair","1234");
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(!conn.isClosed() && conn !=null )
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public static void close(Statement stmt) {
		
		try {
			if(!stmt.isClosed() && stmt!=null) stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			if(!conn.isClosed() && conn != null) conn.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if(!conn.isClosed() && conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		
		try {
			if(!rset.isClosed() && rset!=null) rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

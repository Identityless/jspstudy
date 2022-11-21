package jspbook.ch07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3307/jspdb?allowPublicKeyRetrieval=true"
			+ "&useUnicode=true&characterEncoding=utf8&"
			+ "useSSL=false&serverTimezone=UTC";
	
	public ArrayList<StudentVO> getStudentList() {
		connect();
		ArrayList<StudentVO> studentlist = new ArrayList<StudentVO>();
		String sql = "select * from student ";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentVO student = new StudentVO();
				student.setId(rs.getString("id"));
				student.setPasswd(rs.getString("passwd"));
				student.setUsername(rs.getString("username"));
				student.setSnum(rs.getString("snum"));
				student.setDepart(rs.getString("depart"));
				student.setMobile(rs.getString("mobile"));
				student.setEmail(rs.getString("email"));
				studentlist.add(student);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return studentlist;
	}
	
	private void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "passwd");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

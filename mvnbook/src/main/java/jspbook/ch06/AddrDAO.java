package jspbook.ch06;

import java.sql.*;
import java.util.ArrayList;
public class AddrDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3307/jspdb?allowPublicKeyRetrieval=true" // 본인 로컬에서 mysql은 3307이라서 포트번호가 저럼. 다른 컴퓨터에서 돌릴 때
			+ "&useUnicode=true&characterEncoding=utf8&"				// 수정해야함.
			+ "useSSL=false&serverTimezone=UTC";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "passwd");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
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
	
	public void add(AddrVO ab) {
		connect();
		String sql = "insert into address values (?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ab.getUsername());
			pstmt.setString(2, ab.getTel());
			pstmt.setString(3, ab.getEmail());
			pstmt.setString(4, ab.getSex());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public ArrayList<AddrVO> getAddrList(){
		connect();
		ArrayList<AddrVO> addrlist = new ArrayList<>();
		String sql = "select * from address";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AddrVO ab = new AddrVO();
				ab.setUsername(rs.getString("username"));
				ab.setTel(rs.getString("tel"));
				ab.setEmail(rs.getString("email"));
				ab.setSex(rs.getString("sex"));
				
				addrlist.add(ab);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return addrlist;
	}
}

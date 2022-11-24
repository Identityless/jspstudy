package kimwoojoong_free.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kimwoojoong_free.domain.Member;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	private String jdbc_url = "jdbc:mysql://localhost:3307/jspdb?allowPublicKeyRetrieval=true"
			+ "&useUnicode=true&characterEncoding=utf8&"
			+ "useSSL=false&serverTimezone=UTC";
	
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
	
	public boolean add(Member vo) {
		connect();
		String sql = "insert into members values(id, passwd, uname, age, sex, address, tell, trainer) (?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getUname());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getSex());
			pstmt.setString(6, vo.getAddress());
			pstmt.setString(7, vo.getTell());
			pstmt.setInt(8, vo.getTrainer());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public ArrayList<Member> getMemberList() {
		connect();
		ArrayList<Member> memberList = new ArrayList<>();
		String sql = "select * from members ";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Member vo = new Member();
				vo.setSeq(rs.getInt("seq"));
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setUname(rs.getString("uname"));
				vo.setAge(rs.getInt("age"));
				vo.setSex(rs.getString("sex"));
				vo.setAddress(rs.getString("address"));
				vo.setTell(rs.getString("tell"));
				vo.setTrainer(rs.getInt("trainer"));
				memberList.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return memberList;
	}
	
	public Member read(String id) throws SQLException {
		connect();
		Member vo = new Member();
		String sql = "select * from members where id=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			vo.setSeq(rs.getInt("seq"));
			vo.setId(rs.getString("id"));
			vo.setPasswd(rs.getString("passwd"));
			vo.setUname(rs.getString("uname"));
			vo.setSex(rs.getString("sex"));
			vo.setAddress(rs.getString("address"));
			vo.setTell(rs.getString("tell"));
			vo.setTrainer(rs.getInt("trainer"));
			rs.close();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	public boolean update(Member vo) {
		connect();
		String sql = "update members set passwd=?, uname=?, age=?, sex=?, address=?, tell=?, trainer=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPasswd());
			pstmt.setString(2, vo.getUname());
			pstmt.setInt(3, vo.getAge());
			pstmt.setString(4, vo.getSex());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getTell());
			pstmt.setInt(7, vo.getTrainer());
			pstmt.setString(8, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public void delete(String id) {
		connect();
		String sql = "delete from members where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}

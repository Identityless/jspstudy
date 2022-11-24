package kimwoojoong_free.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kimwoojoong_free.domain.Trainer;



public class TrainerDAO {
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
	
	public boolean add(Trainer vo) {
		connect();
		String sql = "insert into trainers values(tname, major) (?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTname());
			pstmt.setString(2, vo.getMajor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public ArrayList<Trainer> getTrainerList() {
		connect();
		ArrayList<Trainer> memberList = new ArrayList<>();
		String sql = "select * from trainers ";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Trainer vo = new Trainer();
				vo.setSeq(rs.getInt("seq"));
				vo.setTname(rs.getString("tname"));
				vo.setMajor(rs.getString("major"));
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
	
	public Trainer read(int seq) {
		connect();
		Trainer vo = new Trainer();
		String sql = "select * from trainers where seq=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			ResultSet rs = pstmt.executeQuery();
			vo.setSeq(rs.getInt("seq"));
			vo.setTname(rs.getString("tname"));
			vo.setMajor(rs.getString("major"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	public boolean update(Trainer vo) {
		connect();
		String sql = "update trainers set tname=? major=? where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTname());
			pstmt.setString(2, vo.getMajor());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public void delete(String tname) {
		connect();
		String sql = "delete from trainers where tname=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}

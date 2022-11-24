package kimwoojoong_free.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kimwoojoong_free.domain.Member;
import kimwoojoong_free.domain.Trainer;
import kimwoojoong_free.persistence.MemberDAO;
import kimwoojoong_free.persistence.TrainerDAO;

public class FitnessService {
	private MemberDAO memberDAO = new MemberDAO();
	private TrainerDAO trainerDAO = new TrainerDAO();
	
	public boolean login(String id, String pw) {
		Member member = null;
		try {
		member = memberDAO.read(id);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		if(member == null) {
			return false;
		}
		if(member.getPasswd().equals(pw)) {
			return true;
		}
		return false;
	}
	
	public Trainer findTrainerbySeq(int seq) {
		Trainer trainer = trainerDAO.read(seq);
		return trainer;
	}
	
	public List<Member> findMemberofTrainer(int seq) {
		List<Member> allmembers = getAllMembers();
		List<Member> membersofTrainer = new ArrayList<>();
		for(Member member : allmembers) {
			if(member.getTrainer() == seq) {
				membersofTrainer.add(member);
			}
		}
		
		return membersofTrainer;
	}
	
	public Member getMemberInfo(String id) {
		Member member = null;
		try {
		member = memberDAO.read(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public List<Member> getAllMembers() {
		List<Member> members = memberDAO.getMemberList();
		return members;
	}
	
	public List<Trainer> getAllTrainers() {
		List<Trainer> trainers = trainerDAO.getTrainerList();
		return trainers;
	}
	
	public boolean signUp(Member member) {
		try {
		memberDAO.add(member);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateMember(Member member) {
		return memberDAO.update(member);
	}
}

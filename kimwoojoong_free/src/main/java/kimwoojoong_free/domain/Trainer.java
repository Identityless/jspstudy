package kimwoojoong_free.domain;

public class Trainer {	// 트레이너 VO 객체
	private int seq;
	private String tname;
	private String major;
	public int getSeq() {
		return seq;
	}
	public String getTname() {
		return tname;
	}
	public String getMajor() {
		return major;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
}

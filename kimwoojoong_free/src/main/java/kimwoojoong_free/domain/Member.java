package kimwoojoong_free.domain;

public class Member {
	private int seq;
	private String id;
	private String passwd;
	private String uname;
	private int age;
	private String sex;
	private String address;
	private String tell;
	private String tname;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getSeq() {
		return seq;
	}
	public String getId() {
		return id;
	}
	public String getPasswd() {
		return passwd;
	}
	public String getUname() {
		return uname;
	}
	public int getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}
	public String getAddress() {
		return address;
	}
	public String getTell() {
		return tell;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	
	
}

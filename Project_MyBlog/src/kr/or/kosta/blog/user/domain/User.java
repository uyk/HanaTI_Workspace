package kr.or.kosta.blog.user.domain;

/**
 * 사용자 정보를 저장하는 도메인 클래스
 * @author 유예겸
 *
 */
public class User {
	
	private String id;			/** 사용자 식별 id */
	private String name;		/** 사용자 이름 */
	private String passwd;		/** 비밀번호 */
	private String email;		/** 이메일 */
	private String regdate;		/** 가입 날짜 */
	
	public User() {
		super();
	}
	
	public User(String id, String name, String passwd, String email, String regdate) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.regdate = regdate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + ", email=" + email + ", regdate=" + regdate
				+ "]";
	}
}

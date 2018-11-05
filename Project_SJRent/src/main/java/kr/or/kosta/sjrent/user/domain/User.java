package kr.or.kosta.sjrent.user.domain;

import java.util.Date;

public class User {
	
	private int seq;
	private String id;
	private String name;
	private String email;
	private String password;
	private String birthday;
	private int gender;
	private int point;
	private String cellphone;
	private int isUser;
	private String regdate;
	
	
	public User() {
		super();
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getCellphone() {
		return cellphone;
	}


	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	public int getIsUser() {
		return isUser;
	}


	public void setIsUser(int isUser) {
		this.isUser = isUser;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		return "User [seq=" + seq + ", id=" + id + ", name=" + name + ", email=" + email + ", password="
				+ password + ", birthday=" + birthday + ", gender=" + gender + ", point=" + point + ", cellphone="
				+ cellphone + ", isUser=" + isUser + ", regdate=" + regdate + "]";
	}

	
}

package kr.or.kosta.blog.guest.domain;

public class GuestNote {
	
	private String guestBookId;
	private String userId;
	private String contents;
	private String regdate;
	
	public GuestNote() {
		super();
	}
	
	public GuestNote(String guestBookId, String userId, String contents, String regdate) {
		super();
		this.guestBookId = guestBookId;
		this.userId = userId;
		this.contents = contents;
		this.regdate = regdate;
	}

	public String getGuestBookId() {
		return guestBookId;
	}

	public void setGuestBookId(String guestBookId) {
		this.guestBookId = guestBookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "GuestNote [guestBookId=" + guestBookId + ", userId=" + userId + ", contents=" + contents + ", regdate=" + regdate + "]";
	}
	
}

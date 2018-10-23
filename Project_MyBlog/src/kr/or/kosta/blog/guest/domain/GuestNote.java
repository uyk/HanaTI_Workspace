package kr.or.kosta.blog.guest.domain;

/** 
 * 방명록 정보를 저장하는 도메인 클래스
 * @author 유예겸
 *
 */
public class GuestNote {
	
	private String guestBookId;			/** 방명록 식별 번호 */
	private String userId;				/** 방명록 작성자 id */
	private String contents;			/** 방명록 내용 */
	private String regdate;				/** 방명록 작성 시각 */
	
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

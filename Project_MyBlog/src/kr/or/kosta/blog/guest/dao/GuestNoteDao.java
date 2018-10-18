package kr.or.kosta.blog.guest.dao;

import java.util.List;

import kr.or.kosta.blog.guest.domain.GuestNote;

/**
 * 방명록 데이터베이스와 연동하는 인터페이스
 * @author 유예겸
 *
 */
public interface GuestNoteDao {
	
	public void create(GuestNote guestNote) throws Exception;
	
	public GuestNote read(String guestBookId) throws Exception;
	
	public void update(GuestNote guestNote) throws Exception;
	
	public void delete(String guestBookId) throws Exception;
	
	public List<GuestNote> listByUserId(String userId) throws Exception;

	public List<GuestNote> listAll() throws Exception;
	
	/** 유저 id와 방명록 id를 비교하여 인증하는 메소드 */
	public GuestNote certify(String guestNoteId, String userId) throws Exception;
}

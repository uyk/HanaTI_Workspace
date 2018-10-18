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
	
	public void update(GuestNote guestNote) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public List<GuestNote> listAll() throws Exception;
	
	/** 유저ID를 받아 본인이 작성한 방명록인지 확인*/
	public GuestNote certify(String userId) throws Exception;
}

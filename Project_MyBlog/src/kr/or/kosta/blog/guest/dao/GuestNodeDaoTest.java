package kr.or.kosta.blog.guest.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.kosta.blog.common.DaoFactory;
import kr.or.kosta.blog.common.JdbcDaoFactory;
import kr.or.kosta.blog.guest.dao.GuestNoteDao;
import kr.or.kosta.blog.guest.domain.GuestNote;

public class GuestNodeDaoTest {
	public static void main(String[] args) {
		DaoFactory factory = new JdbcDaoFactory();
		GuestNoteDao dao = factory.getGuestNoteDao();
		try {
			GuestNote guestNote = new GuestNote();
			/** 방명록 생성 테스트
			guestNote.setUserId("bangry");
			guestNote.setContents("반갑습니다.");
			dao.create(guestNote);
			*/
			/** 방명록 번호로 수정 테스트
			guestNote.setGuestBookId("67");			
			guestNote.setContents("수정2했습니다.");
			dao.update(guestNote);
			*/
			/*
			System.out.println("**** 전체목록 테스트 ****");
			List<GuestNote> list =  dao.listAll();
			for (GuestNote gn : list) {
				System.out.println(gn);		
			}
			*/
			/*
			System.out.println("**** id로 검색 테스트 ****");
			List<GuestNote> list =  dao.listByUserId("bangry");
			for (GuestNote gn : list) {
				System.out.println(gn);		
			}
			*/
			dao.delete("2");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println();
			SQLException ex = (SQLException)e;
			System.out.println(ex.getErrorCode());
		}
	}
}

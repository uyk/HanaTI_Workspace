package kr.or.kosta.blog.board.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.kosta.blog.board.domain.Article;
import kr.or.kosta.blog.common.DaoFactory;
import kr.or.kosta.blog.common.JdbcDaoFactory;

public class JdbcArticleDaoTest {
	public static void main(String[] args) {
		DaoFactory factory = new JdbcDaoFactory();
		ArticleDao dao = factory.getArticleDao();
		try {
			//Article article = new Article();
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
			/**
			System.out.println("**** 전체목록 테스트 ****");
			List<Article> list =  dao.listAll();
			for (Article article2 : list) {
				System.out.println(article2);		
			}
			*/
			/*
			System.out.println("**** 페이징 테스트 ****");
			// 1번 게시판 게시글을 5개씩 출력. 첫번째 페이지
			List<Article> list =  dao.listByPage(1,1,5);
			for (Article article2 : list) {
				System.out.println(article2);
				
			}
			*/
			/*
			System.out.println("**** 페이징 테스트 ****");
			List<Article> list =  dao.listByPage(1,1);
			for (Article article2 : list) {
				System.out.println(article2);
				
			}
			*/
			/*
			System.out.println("**** id로 검색 테스트 ****");
			List<GuestNote> list =  dao.listByUserId("bangry");
			for (GuestNote gn : list) {
				System.out.println(gn);		
			}
			*/			
			
			System.out.println("**** id로 제거 테스트 ****");
			dao.delete("49");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println();
			SQLException ex = (SQLException)e;
			System.out.println(ex.getErrorCode());
		}
	}
}
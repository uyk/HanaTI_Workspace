package kr.or.kosta.blog.common;

import java.lang.reflect.Method;

import javax.sql.DataSource;

import kr.or.kosta.blog.board.dao.ArticleDao;
import kr.or.kosta.blog.board.dao.BoardDao;
import kr.or.kosta.blog.board.dao.JdbcArticleDao;
import kr.or.kosta.blog.board.dao.JdbcBoardDao;
import kr.or.kosta.blog.guest.dao.GuestNoteDao;
import kr.or.kosta.blog.guest.dao.JdbcGuestNoteDao;
import kr.or.kosta.blog.user.dao.JdbcUserDao;
import kr.or.kosta.blog.user.dao.UserDao;

public class JdbcDaoFactory extends DaoFactory {

	@Override
	public UserDao getUserDao() {
		UserDao dao = new JdbcUserDao();
		Class cls = dao.getClass();
		
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

	@Override
	public GuestNoteDao getGuestNoteDao() {
		GuestNoteDao dao = new JdbcGuestNoteDao();
		Class cls = dao.getClass();
		
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

	@Override
	public BoardDao getBoardDao() {
		BoardDao dao = new JdbcBoardDao();
		Class cls = dao.getClass();
		
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

	@Override
	public ArticleDao getArticleDao() {
		ArticleDao dao = new JdbcArticleDao();
		Class cls = dao.getClass();
		
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}

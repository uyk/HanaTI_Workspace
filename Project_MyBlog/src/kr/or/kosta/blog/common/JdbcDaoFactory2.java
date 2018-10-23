package kr.or.kosta.blog.common;

import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.sql.DataSource;

import kr.or.kosta.blog.board.dao.ArticleDao;
import kr.or.kosta.blog.board.dao.BoardDao;
import kr.or.kosta.blog.guest.dao.GuestNoteDao;
import kr.or.kosta.blog.user.dao.UserDao;

/**
 * DaoFactory를 상속하여 dao를 생성하여 해시테이블로 관리하는 팩토리 패턴 클래스
 * 
 * @author 유예겸
 *
 */

public class JdbcDaoFactory2 extends DaoFactory {
	private static final String USER = "kr.or.kosta.blog.user.dao.JdbcUserDao";
	private static final String GUEST = "kr.or.kosta.blog.guest.dao.JdbcGuestNoteDao";
	private static final String BOARD = "kr.or.kosta.blog.board.dao.JdbcBoardDao";
	private static final String ARTICLE = "kr.or.kosta.blog.board.dao.JdbcArticleDao";
	private Hashtable<String, Object> daos;
	
	private String[] daoNames = {USER, GUEST, BOARD, ARTICLE};
	
	public JdbcDaoFactory2() {
		daos = new Hashtable<String, Object>();
		
		for (String className : daoNames) {
			try {
				Object dao = Class.forName(className).newInstance();
				addDataSource(dao);
				daos.put(className, dao);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public UserDao getUserDao() {
		return (UserDao)daos.get(USER);
	}
	
	@Override
	public GuestNoteDao getGuestNoteDao() {
		return (GuestNoteDao)daos.get(GUEST);
	}

	@Override
	public BoardDao getBoardDao() {
		return (BoardDao)daos.get(BOARD);
	}

	@Override
	public ArticleDao getArticleDao() {
		return (ArticleDao)daos.get(ARTICLE);
	}
	
	private void addDataSource(Object dao) {
		Class cls = dao.getClass();
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

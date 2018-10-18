package kr.or.kosta.blog.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.blog.guest.domain.GuestNote;

/**
 * JDBC API로 방명록 데이터베이스를 관리하는 클래스
 * @author 유예겸
 *
 */
public class JdbcGuestNoteDao implements GuestNoteDao {
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** 새로운 방명록을 DB에 생성하는 메소드 */
	@Override
	public void create(GuestNote guestNote) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = 
				"INSERT INTO guestbook \r\n" + 
				"VALUES      (guestbook_seq.nextval, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             sysdate)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, guestNote.getUserId());
			pstmt.setString(2, guestNote.getContents());
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}

	}
	
	/** 방명록 번호로 검색하는 메소드*/
	@Override
	public GuestNote read(String guestBookId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/** 방명록 id로 방명록의 내용을 수정하는 메소드 */
	@Override
	public void update(GuestNote guestNote) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = 
				"UPDATE guestbook \r\n" + 
				"SET    contents = ? \r\n" + 
				"WHERE  guestbook_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, guestNote.getContents());
			pstmt.setString(2, guestNote.getGuestBookId());
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}

	}

	/** 방명록 id로 방명록을 삭제하는 메소드 */
	@Override
	public void delete(String guestBookId) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = 
				"DELETE FROM guestbook \r\n" + 
				"WHERE  guestbook_id =?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, guestBookId);
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}

	}
	
	/** 유저 id로 방명록 목록을 검색하는 메소드 */
	@Override
	public List<GuestNote> listByUserId(String userId) throws Exception {
		List<GuestNote> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT guestbook_id, \r\n" + 
				"       user_id, \r\n" + 
				"       contents, \r\n" + 
				"       To_char(regdate, 'YYYY/MM/DD HH24:MI:SS') regdate \r\n" + 
				"FROM   guestbook \r\n" + 
				"WHERE  user_id = ? \r\n" + 
				"ORDER  BY guestbook_id DESC";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			list = new ArrayList<GuestNote>();
			while(rs.next()) {
				GuestNote guestNote = createGuestNote(rs);
				list.add(guestNote);
			}
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return list;
	}

	/** 전체 방명록을 리스트로 반환하는 메소드 */
	@Override
	public List<GuestNote> listAll() throws Exception {
		List<GuestNote> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT guestbook_id, \r\n" + 
				"       user_id, \r\n" + 
				"       contents, \r\n" + 
				"       To_char(regdate, 'YYYY/MM/DD HH24:MI:SS') regdate \r\n" + 
				"FROM   guestbook \r\n" + 
				"ORDER  BY guestbook_id DESC";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<GuestNote>();
			while(rs.next()) {
				GuestNote guestNote = createGuestNote(rs);
				list.add(guestNote);
			}
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return list;
	}
	
	/** ResultSet의 정보로 방명록 인스턴스를 생성하는 메소드 */
	private GuestNote createGuestNote(ResultSet rs) throws SQLException{
		GuestNote guestNote = new GuestNote();
		guestNote.setGuestBookId(rs.getString("guestbook_id"));
		guestNote.setUserId(rs.getString("user_id"));
		guestNote.setContents(rs.getString("contents"));
		guestNote.setRegdate(rs.getString("regdate"));
		return guestNote;
	}

	/** 유저 id와 방명록 id를 비교하여 인증하는 메소드 */
	@Override
	public GuestNote certify(String guestNoteId, String userId) throws Exception {
		return null;
	}

}

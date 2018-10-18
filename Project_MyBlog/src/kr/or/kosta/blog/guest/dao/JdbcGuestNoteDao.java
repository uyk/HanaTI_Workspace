package kr.or.kosta.blog.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	@Override
	public void update(GuestNote guestNote) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE guestbook \r\n" + 
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

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GuestNote> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuestNote certify(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

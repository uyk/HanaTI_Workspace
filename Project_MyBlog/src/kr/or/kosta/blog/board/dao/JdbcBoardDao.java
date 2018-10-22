package kr.or.kosta.blog.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.blog.board.domain.Board;
import kr.or.kosta.blog.user.domain.User;

public class JdbcBoardDao implements BoardDao {
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Board board) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Board read(String boardId) throws Exception {
		Board board = null;
		
		Connection con =  null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT board_id, \r\n" + 
				"       category, \r\n" + 
				"       title, \r\n" + 
				"       description \r\n" + 
				"FROM   board \r\n" + 
				"WHERE  board_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = createBoard(rs);
			}
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return board;
	}

	@Override
	public void update(Board board) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String boardId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Board> listAll() throws Exception {
		List<Board> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT board_id, \r\n" + 
				"       category, \r\n" + 
				"       title, \r\n" + 
				"       description \r\n" + 
				"FROM   board \r\n";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Board>();
			while(rs.next()) {
				Board board = createBoard(rs);
				list.add(board);
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
	
	private Board createBoard(ResultSet rs) throws SQLException{
		Board board = new Board();
		board.setBoardId(rs.getInt("board_id"));
		board.setCategory(rs.getInt("category"));
		board.setTitle(rs.getString("title"));
		board.setDescription(rs.getString("description"));
		return board;
	}

	@Override
	public int countArticles(int boardId) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		String sql = 
				"SELECT Count(article_id) count\r\n" + 
				"FROM   article \r\n" + 
				"WHERE  board_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return count;
	}

}
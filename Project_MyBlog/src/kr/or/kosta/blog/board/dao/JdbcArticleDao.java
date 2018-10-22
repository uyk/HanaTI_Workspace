package kr.or.kosta.blog.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.blog.board.domain.Article;
import kr.or.kosta.blog.common.Params;

public class JdbcArticleDao implements ArticleDao {
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Article article) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = 
				"INSERT INTO article \r\n" + 
				"            (article_id, \r\n" + 
				"             board_id, \r\n" + 
				"             writer, \r\n" + 
				"             subject, \r\n" + 
				"             content, \r\n" + 
				"             ip, \r\n" + 
				"             passwd, \r\n" + 
				"             group_no, \r\n" + 
				"             level_no, \r\n" + 
				"             order_no) \r\n" + 
				"VALUES     (article_id_seq.nextval, \r\n" + 
				"            ?, \r\n" + 
				"            ?, \r\n" + 
				"            ?, \r\n" + 
				"            ?, \r\n" + 
				"            ?, \r\n" + 
				"            ?, \r\n" + 
				"            ?, \r\n" + 
				"            0, \r\n" + 
				"            0";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getBoardId());
			pstmt.setString(2, article.getWriter());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getContent());
			pstmt.setString(5, article.getIp());
			pstmt.setString(6, article.getPasswd());
			// 신규글
			if(article.getGroupNo() == 0) {
				pstmt.setString(7, "article_id_seq.currval");
				pstmt.setInt(8, 0);
				pstmt.setInt(9, 0);
			}
			// 덧글
			else {
				pstmt.setInt(7, article.getGroupNo());
				pstmt.setInt(8, article.getLevelNo());
				pstmt.setInt(9, article.getOrderNo());
			}
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}

	}

	@Override
	public Article read(String articleId) throws Exception {
		Article article = null;
		
		Connection con =  null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT article_id, \r\n" + 
				"       board_id, \r\n" + 
				"       writer, \r\n" + 
				"       subject, \r\n" + 
				"       content, \r\n" + 
				"       To_char(regdate, 'YYYY-MM-DD HH24:MI') regdate, \r\n" + 
				"       hitcount, \r\n" + 
				"       ip, \r\n" + 
				"       passwd, \r\n" + 
				"       attach_file, \r\n" + 
				"       group_no, \r\n" + 
				"       level_no, \r\n" + 
				"       order_no \r\n" + 
				"FROM   article \r\n" + 
				"WHERE  article_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, articleId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = createArticle(rs);
			}
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return article;
	}

	@Override
	public void update(Article article) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String articleId) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 
				"DELETE FROM article \r\n" + 
				"WHERE  article_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, articleId);
			rs = pstmt.executeQuery();
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}

	}

	/** 페이징 처리없이 모든 카테고리의 게시글 목록을 가져오는 메소드 */
	@Override
	public List<Article> listAll() throws Exception {
		List<Article> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT article_id, \r\n" + 
				"       board_id, \r\n" + 
				"       writer, \r\n" + 
				"       subject, \r\n" + 
				"       content, \r\n" + 
				"       To_char(regdate, 'YYYY-MM-DD HH24:MI') regdate, \r\n" + 
				"       hitcount, \r\n" + 
				"       ip, \r\n" + 
				"       passwd, \r\n" + 
				"       attach_file, \r\n" + 
				"       group_no, \r\n" + 
				"       level_no, \r\n" + 
				"       order_no \r\n" + 
				"FROM   article \r\n" + 
				"ORDER  BY group_no DESC, \r\n" + 
				"          order_no ASC";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while(rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
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

	/** 선택페이지에 따른 게시글 목록 반환 */	
	@Override
	public List<Article> listByPage(int boardId, int page) throws Exception {
		return listByPage(page, 10, boardId);
	}

	/** 선택페이지, 조회 목록개수에 따른 게시글 목록 반환 */
	@Override
	public List<Article> listByPage(int boardId, int page, int listSize) throws Exception {
		List<Article> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql =
				"SELECT article_id, \r\n" + 
				"       board_id, \r\n" + 
				"       writer, \r\n" + 
				"       subject, \r\n" + 
				"       content, \r\n" + 
				"       regdate, \r\n" + 
				"       hitcount, \r\n" + 
				"       ip, \r\n" + 
				"       passwd, \r\n" + 
				"       attach_file, \r\n" + 
				"       group_no, \r\n" + 
				"       level_no, \r\n" + 
				"       order_no \r\n" + 
				"FROM   (SELECT Ceil(rownum / ?) request_page, \r\n" + 
				"               article_id, \r\n" + 
				"               board_id, \r\n" + 
				"               writer, \r\n" + 
				"               subject, \r\n" + 
				"               content, \r\n" + 
				"               regdate, \r\n" + 
				"               hitcount, \r\n" + 
				"               ip, \r\n" + 
				"               passwd, \r\n" + 
				"               attach_file, \r\n" + 
				"               group_no, \r\n" + 
				"               level_no, \r\n" + 
				"               order_no \r\n" + 
				"        FROM   (SELECT article_id, \r\n" + 
				"                       board_id, \r\n" + 
				"                       writer, \r\n" + 
				"                       subject, \r\n" + 
				"                       content, \r\n" + 
				"                       To_char(regdate, 'YYYY-MM-DD HH24:MI') regdate, \r\n" + 
				"                       hitcount, \r\n" + 
				"                       ip, \r\n" + 
				"                       passwd, \r\n" + 
				"                       attach_file, \r\n" + 
				"                       group_no, \r\n" + 
				"                       level_no, \r\n" + 
				"                       order_no \r\n" + 
				"                FROM   article \r\n" + 
				"                WHERE  board_id = ? \r\n" + 
				"                ORDER  BY article_id DESC)) \r\n" + 
				"WHERE  request_page = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, listSize);
			pstmt.setInt(2, boardId);
			pstmt.setInt(3, page);
			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while(rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
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

	@Override
	public List<Article> listByPage(int boardId, int page, int listSize, String searchType, String searchValue)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> listByPage(Params params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/** 검색유형, 검색값에 따른 게시글 개수 반환 - 페이징 처리 시 필요 */	
	@Override
	public int countBySearch(String searchType, String searchValue, int boardId) throws Exception {
		int count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =
				"SELECT Count(article_id) count \r\n" + 
				"FROM   article \r\n" + 
				"WHERE  board_id = ?";
		
		// 검색 유형별 WHERE 절 동적 추가
		if(searchType != null){
			switch (searchType) {
				case "subject":
					sql += " and subject LIKE ? \r\n";
					searchValue = "%" + searchValue + "%";
					break;
				case "writer":  
					sql += " and writer LIKE ? \r\n";
					searchValue = "%" + searchValue + "%";
					break;
			}
		}
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			
			// 전체검색이 아닌경우 경우
			if(searchType != null){
				pstmt.setString(2, searchValue);
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return count;
	}

	@Override
	public int countBySearch(Params params) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	private Article createArticle(ResultSet rs) throws SQLException{
		Article article = new Article();
		article.setArticleId(rs.getInt("article_id"));
		article.setBoardId(rs.getInt("board_id"));
		article.setWriter(rs.getString("writer"));
		article.setSubject(rs.getString("subject"));
		article.setContent(rs.getString("content"));
		article.setRegdate(rs.getString("regdate"));
		article.setHitcount(rs.getInt("hitcount"));
		article.setIp(rs.getString("ip"));
		article.setPasswd(rs.getString("passwd"));
		article.setAttachFile(rs.getString("attach_file"));
		article.setGroupNo(rs.getInt("group_no"));
		article.setLevelNo(rs.getInt("level_no"));
		article.setOrderNo(rs.getInt("order_no"));
		return article;
	}

}
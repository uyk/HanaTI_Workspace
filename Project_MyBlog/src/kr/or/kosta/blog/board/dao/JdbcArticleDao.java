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
		// TODO Auto-generated method stub

	}

	@Override
	public Article read(String articleId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Article article) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String articleId) throws Exception {
		// TODO Auto-generated method stub

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
				"       regdate, \r\n" + 
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

	@Override
	public List<Article> listByPage(int page, int boardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> listByPage(int page, int listSize, int boardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> listByPage(int page, int listSize, String searchType, String searchValue, int boardId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> listByPage(Params params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBySearch(String searchType, String searchValue, int boardId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
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

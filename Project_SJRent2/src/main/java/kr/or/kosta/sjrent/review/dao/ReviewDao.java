package kr.or.kosta.sjrent.review.dao;

import java.util.List;
import kr.or.kosta.sjrent.review.domain.Review;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface ReviewDao {
	
	public boolean create(Review review) throws Exception;
	
	public Review read(int number) throws Exception;

	public boolean update(Review review) throws Exception;
	
	public boolean delete(int number) throws Exception;

	public List<Review> listByModel(String modelName) throws Exception;

	public List<Review> listByModelByPage(int page, int listSize, String modelName) throws Exception;

	public int countByModel(String modelName) throws Exception;
	
	public List<Review> listByUserByPage(int page, int listSize, String userId) throws Exception;
	
	public int countByUser(String userId) throws Exception;
	
}

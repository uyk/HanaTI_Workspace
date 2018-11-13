package kr.or.kosta.sjrent.review.service;

import java.util.List;

import kr.or.kosta.sjrent.review.domain.Review;

public interface ReviewService {
	public boolean create(Review review) throws Exception;
	
	public Review read(int number) throws Exception;

	public boolean update(Review review) throws Exception;
	
	public boolean delete(int number) throws Exception;

	public List<Review> listById(String userId) throws Exception;
	
	public List<Review> listByModel(String modelName) throws Exception;
	
	public List<Review> listByModelByPage(int page, int listSize, String modelName) throws Exception;

	public List<Review> listByUserByPage(int page, int listSize, String userId) throws Exception;

	public int countByModel(String modelName) throws Exception;
	
	public int countByUser(String userId) throws Exception;
}

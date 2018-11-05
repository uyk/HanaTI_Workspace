package kr.or.kosta.sjrent.review.service;

import java.util.List;

import kr.or.kosta.sjrent.review.dao.ReviewDao;
import kr.or.kosta.sjrent.review.domain.Review;

public class ReviewServiceImpl implements ReviewService {

	ReviewDao reviewDao;
	
	
	public ReviewDao getReviewDao() {
		return reviewDao;
	}

	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	public void create(Review review) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public Review read(int number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Review review) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int number) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Review> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> listByPage(int page, int listSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> listByUser(int page, int listSize, String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> listByModel(int page, int listSize, String modelName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByUser(String User) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countByModel(String modelName) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}

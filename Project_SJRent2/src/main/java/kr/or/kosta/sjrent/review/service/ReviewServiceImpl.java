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
	public boolean create(Review review) throws Exception {
		return reviewDao.create(review);
	}

	@Override
	public Review read(int number) throws Exception {
		return reviewDao.read(number);
	}

	@Override
	public boolean update(Review review) throws Exception {
		return reviewDao.update(review);
	}

	@Override
	public boolean delete(int number) throws Exception {
		return reviewDao.delete(number);
	}

	@Override
	public List<Review> listByModel(String modelName) throws Exception {
		return reviewDao.listByModel(modelName);
	}

	@Override
	public List<Review> listByModelByPage(int page, int listSize, String modelName) throws Exception {
		return reviewDao.listByModelByPage(page, listSize, modelName);
	}

	@Override
	public int countByModel(String modelName) throws Exception {
		return reviewDao.countByModel(modelName);
	}
}

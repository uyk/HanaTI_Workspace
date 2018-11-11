package kr.or.kosta.sjrent.review.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.review.domain.Review;
import kr.or.kosta.sjrent.review.service.ReviewService;
import kr.or.kosta.sjrent.review.service.ReviewServiceImpl;

/**
 * Review add 처리
 * 
 * @author 남수현
 */
public class ReviewUpdateController implements Controller {
	private XMLObjectFactory factory;
	private ReviewService reviewService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		reviewService = (ReviewService) factory.getBean(ReviewServiceImpl.class);
		String reviewNumberS = request.getParameter("number");
		String modelName = request.getParameter("modelName");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String picture = request.getParameter("picture");
		String evalScoreS = request.getParameter("evalScore");
		int reviewNumber = 0;
		int evalScore = 0;
		if (evalScoreS != null && !evalScoreS.equals("")) {
			evalScore = Integer.parseInt(evalScoreS);
		}
		if(reviewNumberS != null && !reviewNumberS.equals("")) {
			reviewNumber = Integer.parseInt(reviewNumberS);
		}
		Review review = new Review();
		review.setNumber(reviewNumber);
		review.setTitle(title);
		review.setPicture(picture);
		review.setModelName(modelName);
		review.setEvalScore(evalScore);
		review.setContent(content);
		try {
			if (reviewService.update(review)) {
				mav.addObject("message", "update_success");
			} else {
				mav.addObject("message", "update_fail");
			}
		} catch (Exception e) {
			mav.addObject("message", "update_error:"+e);
		}
		mav.setView("/mypage/myReviewList.jsp");
		return mav;
	}

}

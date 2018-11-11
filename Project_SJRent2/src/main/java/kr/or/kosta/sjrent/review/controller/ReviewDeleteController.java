package kr.or.kosta.sjrent.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.review.domain.Review;
import kr.or.kosta.sjrent.review.service.ReviewService;

/**
 * 리뷰 id를 받아서 db에서 리뷰 삭제
 * 
 * @author 남수현
 */
public class ReviewDeleteController implements Controller {
	private XMLObjectFactory factory;
	private Review review;
	private ReviewService reviewService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		reviewService = (ReviewService) factory.getBean(ReviewService.class);

		String inputReviewSeq = request.getParameter("reviewSeq");
		if (inputReviewSeq != null && !inputReviewSeq.equals("")) {
			int reviewSeq = Integer.parseInt(inputReviewSeq);
			boolean result = false;
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e2) {
			}
			try {
				if (reviewService.delete(reviewSeq)) {
					mav.addObject("message", "delete_success");
				} else {
					mav.addObject("message", "delete_fail");
				}
			} catch (Exception e) {
				mav.addObject("message", "delete_error:" + e);
			}
			mav.setView("/mypage/myReviewList.jsp");
			return mav;
		}

		return null;
	}

}

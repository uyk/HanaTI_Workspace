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
import kr.or.kosta.sjrent.review.service.ReviewServiceImpl;

/**
 * 리뷰 id를 받아서 db에서 리뷰 삭제
 * 
 * @author 남수현
 */

/**
 * 리뷰삭제 컨트롤러
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
		reviewService = (ReviewService) factory.getBean(ReviewServiceImpl.class);

		String inputReviewSeq = request.getParameter("reviewSeq");
		// String[] inputReviewSeq = request.getParameterValues("reviewSeq");

		/*
		 * System.out.println(inputReviewSeq); for (int i = 0; i <
		 * inputReviewSeq.length; i++) { System.out.println(inputReviewSeq[i]); }
		 */

		// checkBox 여러개 선택시 for문으로 삭제

		int reviewSeq = Integer.parseInt(inputReviewSeq);

		if (inputReviewSeq != null && !inputReviewSeq.equals("")) {
			try {
				if (reviewService.delete(reviewSeq)) {

					// mav.addObject("message", "delete_success");
					System.out.println("삭제 성공");
					response.sendRedirect("/sjrent/review/list2.rent");
					return null;

				} else {
					// mav.addObject("message", "delete_fail");
					System.out.println("삭제 실패");

				}
			} catch (Exception e) {
				mav.addObject("message", "delete_error:" + e);
			}
			mav.setView("/mypage/myReview.jsp");

		}

		return null;
	}
}
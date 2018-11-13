package kr.or.kosta.sjrent.review.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.review.domain.Review;
import kr.or.kosta.sjrent.review.service.ReviewService;
import kr.or.kosta.sjrent.review.service.ReviewServiceImpl;
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;


/**
 * id로 user를 검색하는 컨트롤러
 * 
 * @author 윤형철
 *
 */

public class ReviewListController2 implements Controller {
	private ModelAndView mav;
	private ReviewService reviewService;
	private JSONObject obj;

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		reviewService = (ReviewService)factory.getBean(ReviewServiceImpl.class);
	
		String id = (String)request.getAttribute("loginId");
		List<Review> reviewList = new ArrayList<Review>();

		try {
			reviewList = reviewService.listById(id);
			//System.out.println("reviewList : 찍어본다 "+reviewList);

			mav.addObject("reviewList", reviewList);
			mav.setView("/mypage/myReview.jsp");

			return mav;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//obj.put("name", user.getName());
		//obj.put("email", user.getEmail());
		//obj.put("phone", user.getCellphone());
		
		// 응답으로 json 객체 보내고 컨트롤러 종료
		try {
			response.getWriter().print(obj);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mav;
	}

}

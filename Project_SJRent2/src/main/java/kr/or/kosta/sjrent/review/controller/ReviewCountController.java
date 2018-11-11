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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.review.domain.Review;
import kr.or.kosta.sjrent.review.service.ReviewService;
import kr.or.kosta.sjrent.review.service.ReviewServiceImpl;

/**
 * 유저 혹은 모델을 받아서 조건에 따라 리스트 count
 * @author 남수현
 */
public class ReviewCountController implements Controller {
	private XMLObjectFactory factory;
	private ModelAndView mav;
	private Review review;
	private ReviewService reviewService;
	private JSONArray jsonArray;
	
   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException {
      factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
      reviewService = (ReviewService)factory.getBean(ReviewServiceImpl.class);
      jsonArray = new JSONArray();
      String modelName = request.getParameter("modelName");
      String userId = request.getParameter("userId");
      int resultCount = 0;
      if(modelName != null) {
    	  try {
			resultCount = reviewService.countByModel(modelName);
		} catch (Exception e) {
			
		}
      }else if(userId !=null) {
    	  try {
			resultCount = reviewService.countByUser(userId);
		} catch (Exception e) {

		}
      }
      PrintWriter out = null;
	  try {
		out = response.getWriter();
	  } catch (IOException e2) {
	  }
	  out.println(resultCount);
      return null;
   }
}

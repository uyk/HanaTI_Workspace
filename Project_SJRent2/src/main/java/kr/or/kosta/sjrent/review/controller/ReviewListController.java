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
import kr.or.kosta.sjrent.common.converter.ObjectToJson;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.review.domain.Review;
import kr.or.kosta.sjrent.review.service.ReviewService;
import kr.or.kosta.sjrent.review.service.ReviewServiceImpl;

/**
 * 유저 혹은 모델을 받아서 조건에 따라 리스트 출력 
 * @author 남수현
 */
public class ReviewListController implements Controller {
	private XMLObjectFactory factory;
	private ReviewService reviewService;
	private JSONArray jsonArray;
	private ObjectToJson otj;
	
   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException {
      factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
      reviewService = (ReviewService)factory.getBean(ReviewServiceImpl.class);
      jsonArray = new JSONArray();
      otj = new ObjectToJson();
      
      String userId = (String) request.getAttribute("loginId");
      String modelName = request.getParameter("modelName");
      String pageS = request.getParameter("page");
      String listSizeS = request.getParameter("listSzie");
      List<Review> reviewList = new ArrayList<Review>();
      
      int page = 1;
      int listSize = 10000;
      if(pageS!=null&&!pageS.equals("")) {
    	page = Integer.parseInt(pageS);  
      }
      if(listSizeS!=null&&!listSizeS.equals("")) {
    	listSize = Integer.parseInt(listSizeS);  
      }
      if(modelName != null) {
    	  try {
			reviewList = reviewService.listByModelByPage(page, listSize, modelName);
		} catch (Exception e) {
			
		}
      }else if(userId !=null) {
    	  try {
			reviewList = reviewService.listByUserByPage(page, listSize, userId);
		} catch (Exception e) {

		}
      }
      for(Review review : reviewList) {
    	  System.out.println(review.getDate());
    	  jsonArray.add(otj.ObjectToJsonObject(review));
      }
      response.setCharacterEncoding("utf-8");
      try {
    	  //System.out.println(jsonArray);
		response.getWriter().print(jsonArray);
	} catch (IOException e) {
		e.printStackTrace();
	}
      return null;
   }
}

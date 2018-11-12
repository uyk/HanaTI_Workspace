package kr.or.kosta.sjrent.rent.controller;

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
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;

/**
 * 대여를 위한 정보와 유저정보를 예약 페이지로 넘기는 컨트롤러
 * @author 유예겸
 *
 */
public class RentPageDataController implements Controller{
	private XMLObjectFactory factory;
	private UserService userService;
	private ModelAndView mav;

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException {
      factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
      userService = (UserService) factory.getBean(UserServiceImpl.class);
      mav = new ModelAndView();
      List<Map<String,String>> dataMapList = new ArrayList<Map<String,String>>();
      User user = null;
      try {
		  user = userService.read((String)request.getAttribute("loginId")); 
      }
      catch (Exception e) {
         mav.addObject("result", "fail");
         mav.setView("/rent/search.jsp");
         return mav;
      }
      
      String[] startDate = request.getParameterValues("startDate");
      String[] endDate = request.getParameterValues("endDate");
      String[] pickupPlace = request.getParameterValues("pickupPlace");
      String[] amountMoney = request.getParameterValues("amountMoney");
      String[] type = request.getParameterValues("type");
      String[] picture = request.getParameterValues("picture");

      for(int i = 0; i < startDate.length; i++) {
    	  Map<String, String> temp = new HashMap<String,String>();
    	  temp.put("startDate", startDate[i]);
    	  temp.put("endDate", endDate[i]);
    	  if(pickupPlace == null) temp.put("pickupPlace", "방문수령");
    	  else temp.put("pickupPlace", pickupPlace[i]);
    	  temp.put("amountMoney", amountMoney[i]);
    	  temp.put("type", type[i]);
    	  temp.put("picture", picture[i]);
    	  dataMapList.add(temp);
      }
      mav.addObject("resultMap", dataMapList);
      mav.addObject("userName", user.getName());
      mav.addObject("userCellphone", user.getCellphone());
      mav.addObject("userEmail", user.getEmail());
      mav.setView("/rent/rent.jsp");
      
      return mav;
   }
}

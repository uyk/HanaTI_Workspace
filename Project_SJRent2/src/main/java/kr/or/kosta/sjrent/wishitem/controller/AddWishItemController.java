package kr.or.kosta.sjrent.wishitem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;
import kr.or.kosta.sjrent.wishitem.domain.WishItem;
import kr.or.kosta.sjrent.wishitem.service.WishItemService;
import kr.or.kosta.sjrent.wishitem.service.WishItemServiceImpl;

/**
 * wishitem 추가 controller
 * @author 남수현
 */

public class AddWishItemController implements Controller {
	private XMLObjectFactory factory;
	private WishItemService wishItemService;
	private UserService userService;
	private JSONObject obj;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
	      factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
	      wishItemService = (WishItemService) factory.getBean(WishItemServiceImpl.class);
	      userService = (UserService) factory.getBean(UserServiceImpl.class);
	      String modelName = request.getParameter("modelName");
	      String startDate = request.getParameter("startDate");
	      String endDate = request.getParameter("endDate");
	      String amountMoney = request.getParameter("amountMoney");
	      String picture = request.getParameter("picture");
	      String type = request.getParameter("type");
	      String fuelType = request.getParameter("fuelType");
    	  PrintWriter out = null;
		  try {
			out = response.getWriter();
		  } catch (IOException e2) {
		  }
	      WishItem wishItem = new WishItem();
	      User user = new User();
	      if(request.getAttribute("loginId")!=null && !request.getAttribute("loginId").equals("")) {
	    	  try {
				user = userService.read((String)request.getAttribute("loginId"));
			} catch (Exception e) {
				out.println(e);
			}
	      }else {
	    	  System.out.println("로그인 하세요");
	    	  try {
				user = userService.read("gloomycloud");
			} catch (Exception e) {
				out.println(e);
			}
	      }
	      wishItem.setUserNumber(user.getSeq());
	      wishItem.setUserId(user.getId());
	      wishItem.setType(type);
	      wishItem.setStartDate(startDate);
	      wishItem.setPicture(picture);
	      wishItem.setModelName(modelName);
	      wishItem.setFuelType(fuelType);
	      wishItem.setEndDate(endDate);
	      if(amountMoney != null && !amountMoney.equals("")) {
	    	  wishItem.setAmountMoney(Integer.parseInt(amountMoney));
	      }
	      try {
	    	  if(wishItemService.create(wishItem)) {
	    		  out.println("success");
	    	  }else {
	    		  out.println("fail");
	    	  }
	    	  
	      } catch (Exception e) {
	    	out.println("fail");
	      }
		return null;
	}

}
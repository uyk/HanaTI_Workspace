package kr.or.kosta.sjrent.rent.controller;

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
      User user = null;
      try {
		  user = userService.read((String)request.getAttribute("loginId")); 
      }
      catch (Exception e) {
         mav.addObject("result", "fail");
         mav.setView("/rent/search.jsp");
         return mav;
      }
      
      String startDate = request.getParameter("startDate");
      String endDate = request.getParameter("endDate");
      String pickupPlace = request.getParameter("pickupPlace");
      String amountMoney = request.getParameter("amountMoney");

      mav.addObject("startDate", startDate);
      mav.addObject("endDate", endDate);
      mav.addObject("pickupPlace", pickupPlace);
      mav.addObject("amountMoney", amountMoney);
      mav.addObject("userName", user.getName());
      mav.addObject("userCellphone", user.getCellphone());
      mav.addObject("userEmail", user.getEmail());
      mav.setView("/rent/rent.jsp");
      
      return mav;
   }
}

package kr.or.kosta.sjrent.rent.controller;

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
import kr.or.kosta.sjrent.model.service.ModelService;
import kr.or.kosta.sjrent.model.service.ModelServiceImpl;
import kr.or.kosta.sjrent.rent.domain.Rent;
import kr.or.kosta.sjrent.rent.service.RentService;
import kr.or.kosta.sjrent.rent.service.RentServiceImpl;
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;

/**
 * rent id를 받아서 db에서 렌트 취소 처리 
 * @author 남수현
 */
public class RentCancelController implements Controller {
	private XMLObjectFactory factory;
	private UserService userService;
	private RentService rentService;
	private ModelService modelService;
	private ModelAndView mav;

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException {
      factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
      rentService = (RentService) factory.getBean(RentServiceImpl.class);
      
      String inputRentSeq = request.getParameter("rentSeq");
      if(inputRentSeq != null && !inputRentSeq.equals("")) {
          int rentSeq = Integer.parseInt(inputRentSeq);
          boolean result = false;
    	  PrintWriter out = null;
		  try {
			out = response.getWriter();
		  } catch (IOException e2) {
		  }
    	  try {
			result = rentService.cancel(rentSeq);
		  } catch (Exception e1) {
			out.println("cancelError : "+e1);
			return null;
		  }
    	  if(result) {
    		  out.println("success");
    		  return null;
    	  }else {
    		  out.println("fail");
    		  return null;
    	  }
      }
	return null;
   }
   
}

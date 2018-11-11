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
 * wishitem 삭제 controller
 * @author 남수현
 */

public class WishItemDeleteController implements Controller {
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
	      String wishItemSeqString = request.getParameter("number");
    	  PrintWriter out = null;
		  try {
			out = response.getWriter();
		  } catch (IOException e2) {
		  }
	      int wishItemSeq = 0;
	      if(wishItemSeqString == null || wishItemSeqString.equals("")) {
	    	  wishItemSeq = Integer.parseInt("wishItemSeq");
	      }else {
	    	  out.println("fail:need wishItemSeq");
	      }
	      try {
	    	  if(wishItemService.delete(wishItemSeq)) {
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
package kr.or.kosta.sjrent.wishitem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.service.QnAService;
import kr.or.kosta.sjrent.qna.service.QnAServiceImpl;
import kr.or.kosta.sjrent.wishitem.domain.WishItem;
import kr.or.kosta.sjrent.wishitem.service.WishItemService;
import kr.or.kosta.sjrent.wishitem.service.WishItemServiceImpl;


/**
 * /wishitem/list.rent에 대한 요청 처리 컨트롤러
 * @author 남수현
 *
 */
public class WishItemListController implements Controller {
	
	private WishItemService wishItemService;
	private ModelAndView mav;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		wishItemService = (WishItemService) factory.getBean(WishItemServiceImpl.class);
		
		List<WishItem> list = null;
//		if((String)request.getAttribute("loginId")!=null) {
//			try {
//				list = wishItemService.listByUser((String)request.getAttribute("loginId"));
//			} catch (Exception e) {
//				throw new ServletException("wishItemService.list() 예외 발생", e);
//			}			
//		}else {
//			mav.setView("/user/login2.jsp");
//			return mav;
//		}
		try {
			list = wishItemService.listByUser("gloomycloud");
		} catch (Exception e) {
			throw new ServletException("wishItemService.list() 예외 발생", e);
		}
		mav.addObject("list", list);
		mav.setView("/wish/wish_list.jsp");
		return mav;
	}
}

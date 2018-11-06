package kr.or.kosta.sjrent.rent.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.rent.domain.Rent;
import kr.or.kosta.sjrent.rent.service.RentService;
import kr.or.kosta.sjrent.rent.service.RentServiceImpl;

/**
 * user id를 인자로 받아 전체 예약 목록을 list 객체에 담아 rent/rent_list.jsp로 보내는 컨트롤러
 * @author 유예겸
 *
 */
public class RentListController implements Controller {
	private XMLObjectFactory factory;
	private RentService rentService;
	private ModelAndView mav;
	private JSONObject obj;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		rentService = (RentService) factory.getBean(RentServiceImpl.class);
		obj = new JSONObject();
		mav = new ModelAndView();

		String id = request.getParameter("id");
		System.out.println("RentListController id : " + id);
		List<Rent> list = null;
		try {
			list = rentService.listByUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("list", list);
		mav.setView("/rent/rent_list.jsp");
		
		return mav;
	}

}

package kr.or.kosta.sjrent.rent.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.rent.domain.Rent;
import kr.or.kosta.sjrent.rent.service.RentService;
import kr.or.kosta.sjrent.rent.service.RentServiceImpl;

/**
 * rent_seq를 인자로 받아서 rent인스턴스를 생성하고
 * rent/rent_detail.jsp로 보내는 컨트롤러
 * @author 유예겸
 *
 */
public class RentDetailController implements Controller {
	private XMLObjectFactory factory;
	private RentService rentService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		rentService = (RentService) factory.getBean(RentServiceImpl.class);
		mav = new ModelAndView();

		int rentSeq = Integer.parseInt(request.getParameter("rentSeq"));
		System.out.println("RentDetailController rentSeq : " + rentSeq);
		Rent rent = null;
		try {
			rent = rentService.read(rentSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("RentDetailController rent : " + rent);
		mav.addObject("rent", rent);
		mav.setView("/rent/rent_detail.jsp");
		
		return mav;
	}

}

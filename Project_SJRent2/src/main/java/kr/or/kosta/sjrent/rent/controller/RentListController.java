package kr.or.kosta.sjrent.rent.controller;

import java.util.List;

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
 * user id를 인자로 받아서 조회 타입에 따라 예약 목록을 list 객체에 담고 rent/rent_list.jsp로 보내는 컨트롤러
 * @author 유예겸, 남수현
 *
 */
public class RentListController implements Controller {
	private XMLObjectFactory factory;
	private RentService rentService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		rentService = (RentService) factory.getBean(RentServiceImpl.class);
		mav = new ModelAndView();

		String id = request.getParameter("id");
		
		//list 출력 타입에 따라 분기. all은 해당 유저 전체 예약, cancel은 취소 된 예약, uncancel은 취소하지 않느 예약 past는 과거 예약, upComing은 사용 가능한 예약
		String type = request.getParameter("type");
		System.out.println("RentListController id : " + id);
		List<Rent> list = null;
		if(type != null) {
			if(type.equals("all")) {
				try {
					list = rentService.listByUser(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(type.equals("cancel")) {
				try {
					list = rentService.CancellistByUser(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(type.equals("uncancel")) {
				try {
					list = rentService.UncancellistByUser(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(type.equals("past")) {
				try {
					list = rentService.pastListByUser(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(type.equals("upComing")) {
				try {
					rentService.upComingListByUser(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}{
			try {
				list = rentService.listByUser(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.addObject("list", list);
		mav.setView("/rent/rent_list.jsp");
		return mav;
	}

}

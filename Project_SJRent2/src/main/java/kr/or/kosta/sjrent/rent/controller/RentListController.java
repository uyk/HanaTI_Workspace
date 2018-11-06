package kr.or.kosta.sjrent.rent.controller;

import java.io.IOException;

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
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;

public class RentListController implements Controller {
	private XMLObjectFactory factory;
	private UserService userService;
	private RentService rentService;
	private ModelAndView mav;
	private JSONObject obj;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);
		rentService = (RentService) factory.getBean(RentServiceImpl.class);
		obj = new JSONObject();
		mav = new ModelAndView();

		String id = request.getParameter("id");
		User user = null;
		Rent rent = new Rent();
		
		rent.setUserSeq(user.getSeq());
		rent.setUserId(user.getId());
		rent.setInsuranceNumber(Integer.parseInt(request.getParameter("insuranceNumber")));
		rent.setCarNumber(request.getParameter("carNumber"));
		rent.setStartDate(request.getParameter("startDate"));
		rent.setEndDate(request.getParameter("endDate"));
		rent.setPickupPlace(request.getParameter("pickupPlace"));
		rent.setPaidAmount(Integer.parseInt(request.getParameter("paidAmount")));
		rent.setPaymentOption(request.getParameter("paymentOption"));
		rent.setIsCanceled(0);
		System.out.println("RentController rent : " + rent);
		
		try {
			// 예약 성공
			if(rentService.create(rent)) {
				mav.addObject("rent", rent);
				mav.setView("/sjrent/rent/rentResult.jsp");
				return mav;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 예약 실패시 fail을 응답으로 보내고 종료
		obj.put("result", "fail");
		try {
			response.getWriter().print(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

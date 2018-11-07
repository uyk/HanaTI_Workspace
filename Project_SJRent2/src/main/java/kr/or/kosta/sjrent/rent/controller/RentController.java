package kr.or.kosta.sjrent.rent.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

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
 * 유저 id, model name, rent정보를 받아서 rent를 db에 생성하고 
 * 생성한 rent를 /sjrent/rent/rentResult.jsp로 보내는 컨트롤러
 * @author 유예겸
 *
 */
public class RentController implements Controller {
	private XMLObjectFactory factory;
	private UserService userService;
	private RentService rentService;
	private ModelService modelService;
	private ModelAndView mav;
	private JSONObject obj;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);
		rentService = (RentService) factory.getBean(RentServiceImpl.class);
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		obj = new JSONObject();
		mav = new ModelAndView();

		User user = null;
		Rent rent = new Rent();
		
		/*
		try {
			user = userService.read((String)request.getServletContext().getAttribute("loginId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
				modelService.changeCount(request.getParameter("modelName"), 1);
				mav.addObject("rent", rent);
				mav.setView("/sjrent/rent/rentResult.jsp");
				return mav;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		try {
			user = userService.read("uyk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rent.setUserSeq(user.getSeq());
		rent.setUserId(user.getId());
		rent.setInsuranceNumber(1);
		rent.setCarNumber("13허4679");
		rent.setStartDate("2018-12-03");
		rent.setEndDate("2018-12-04");
		rent.setPickupPlace("방문수령");
		rent.setPaidAmount(100000);
		rent.setPaymentOption("카드결제");
		rent.setIsCanceled(0);
		System.out.println("RentController rent : " + rent);
		
		try {
			// 예약 성공
			if(rentService.create(rent)) {
				modelService.changeCount("K5", 1);
				mav.addObject("rent", rent);
				mav.setView("/rent/rent_result.jsp");
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

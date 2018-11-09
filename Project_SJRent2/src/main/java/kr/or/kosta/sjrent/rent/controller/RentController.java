package kr.or.kosta.sjrent.rent.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
 * 유저 id와 rent정보를 받아서 rent를 db에 생성하고 
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
		System.out.println("들어옴.");
		System.out.println(request.getParameter("datas"));
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);
		rentService = (RentService) factory.getBean(RentServiceImpl.class);
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		obj = new JSONObject();
		mav = new ModelAndView();

//		User user = null;
//		try {
//			user = userService.read((String)request.getAttribute("loginId"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		JSONParser jsonparser = new JSONParser();
		JSONArray jsonArray = null;
		try {
			jsonArray = (JSONArray)jsonparser.parse(request.getParameter("datas"));
		
		} catch (ParseException e1) {
			System.out.println("잘못된 형식");
		}
		for(int i = 0; i < jsonArray.size(); i++) {
			Rent rent = new Rent();
			JSONObject rentValue = (JSONObject)jsonArray.get(i);
//			rent.setUserSeq(user.getSeq());
//			rent.setUserId(user.getId());
			rent.setInsuranceNumber(Integer.parseInt((String)rentValue.get("insuranceNumber")));
			List<String> enableCarList = null;
			try {
				enableCarList = modelService.checkEnableCar((String)rentValue.get("startDate"), (String)rentValue.get("endDate"), (String)rentValue.get("modelName"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(enableCarList.size()<1) {
				
			}else {
				String choosedCarNumber = enableCarList.get((int)(Math.random() * enableCarList.size()));
			}
			rent.setCarNumber(request.getParameter("choosedCarNumber"));
			rent.setStartDate((String)rentValue.get("startDate"));
			rent.setEndDate((String)rentValue.get("endDate"));
			rent.setPickupPlace((String)rentValue.get("pickupPlace"));
			rent.setPaidAmount(Integer.parseInt((String)rentValue.get("paidAmount")));
			rent.setPaymentOption((String)rentValue.get("paymentOption"));
			rent.setIsCanceled(0);
			
			System.out.println(rent.getInsuranceNumber());
		}
		
		

//		System.out.println("RentController rent : " + rent);
//		
//		try {
//			// 예약 성공
//			if(rentService.create(rent)) {
//				mav.addObject("rent", rent);
//				mav.setView("/sjrent/rent/rentResult.jsp");
//				return mav;
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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

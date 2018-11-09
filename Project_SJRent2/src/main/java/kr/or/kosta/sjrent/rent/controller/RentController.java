package kr.or.kosta.sjrent.rent.controller;

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

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException {
      factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
      userService = (UserService) factory.getBean(UserServiceImpl.class);
      rentService = (RentService) factory.getBean(RentServiceImpl.class);
      modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
      mav = new ModelAndView();
      
      User user = null;
      try {
         user = userService.read((String)request.getAttribute("loginId"));
         user = userService.read("gloomycloud");
      } catch (Exception e) {
         mav.addObject("result", "fail");
         mav.setView("/rent/search.jsp");
         return mav;
      }
      
      String[] startDates = request.getParameterValues("startDate");
      String[] endDates = request.getParameterValues("endDate");
      String[] insuranceNumbers = request.getParameterValues("insuranceNumber");
      String[] pickupPlaces = request.getParameterValues("pickupPlace");
      String[] paidAmounts = request.getParameterValues("paidAmount");
      String[] paymentOptions = request.getParameterValues("paymentOption");
      String[] modelNames = request.getParameterValues("modelName");

      List<Map<String,String>> resultRents = new ArrayList<Map<String,String>>();
      for(int i = 0; i < modelNames.length; i++) {
         List<String> enableCarList = null;
         try {
            enableCarList = modelService.checkEnableCar(startDates[i], endDates[i], modelNames[i]);
         } catch (Exception e) {
        	 System.out.println("아웃");
            mav.addObject("result", "fail");
            mav.setView("/rent/search.jsp");
            return mav;
         }
         if(!(enableCarList.isEmpty()||enableCarList.size()<1)) {
            Rent rent = new Rent();
            rent.setInsuranceNumber(Integer.parseInt(insuranceNumbers[i]));
            rent.setCarNumber(enableCarList.get((int)(Math.random() * enableCarList.size())));
            rent.setStartDate(startDates[i]);
            rent.setEndDate(endDates[i]);
            rent.setPickupPlace(pickupPlaces[i]);
            rent.setIsCanceled(0);
            rent.setPaidAmount(Integer.parseInt(paidAmounts[i]));
            rent.setPaymentOption(paymentOptions[i]);
            rent.setUserSeq(user.getSeq());
            rent.setUserId(user.getId());
            try {
               if(rentService.create(rent)){
            	  Map<String, String> temp = new HashMap<String,String>();
            	  temp.put("modelName", modelNames[i]);
            	  temp.put("startDate", startDates[i]);
            	  temp.put("endDate", endDates[i]);
            	  temp.put("pickupPlace", pickupPlaces[i]);
                  resultRents.add(temp);
                  modelService.changeCount(modelNames[i], 1);
               }else{
                  mav.addObject("result", "fail");
                  mav.addObject("message", rent.toString()+": 렌트 등록을 할 수 없습니다.");
                  mav.setView("/rent/search.jsp");
                  return mav;
               }
            } catch (Exception e) {
               mav.addObject("result", "fail");
               mav.addObject("message", rent.toString()+" : "+e);
               mav.setView("/rent/search.jsp");
               return mav;
            }
         }else {
            mav.addObject("result", "fail");
            mav.addObject("message", modelNames[i]+"모델은 이용 가능한 차가 없습니다.");
            mav.setView("/rent/search.jsp");
            return mav;
         }
      }
      mav.addObject("resultRents", resultRents);
      mav.setView("/rent/rent_result.jsp");
      return mav;
   }
   
}

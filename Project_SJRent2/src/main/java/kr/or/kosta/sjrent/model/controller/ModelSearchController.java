package kr.or.kosta.sjrent.model.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.params.ModelParams;
import kr.or.kosta.sjrent.model.service.ModelService;
import kr.or.kosta.sjrent.model.service.ModelServiceImpl;

/**
 * 검색된 모델 목록을 뷰로 보내는 컨트롤러
 * 
 * @author 유예겸
 *
 */
public class ModelSearchController implements Controller{
	private ModelService modelService;
	private ModelAndView mav;
	private XMLObjectFactory factory;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		System.out.println("ModelSearchController");

//		String startDate = request.getParameter("startDate");
//		String endDate = request.getParameter("endDate");
//		String type = request.getParameter("type");
		String startDate = "2018-11-15";
		String endDate = "2018-11-17";
		String type = "JSegment";
		
		if(type.equals("all") || type.equals("null")) type = null;
		
		// 인자로 받은 date와 type
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(type);
		
		// 검색 인자를 Params에 저장
		ModelParams modelParams = new ModelParams();
		modelParams.setStartDate("2018-11-15");
		modelParams.setEndDate("2018-11-17");
		modelParams.setType("JSegment");
		
		List<Model> list = null;
		try {
			// Params로 검색한 리스트를 list에 저장
			list = modelService.listBySearch(modelParams);
			// 저장한 리스트를 mav에 추가
			mav.addObject("list", list);
			// rent/search.jsp로 이동
			// 뷰에서 include로 처리하는 것이 좋을 듯
			mav.setView("/rent/search_list.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mav;
	}

}

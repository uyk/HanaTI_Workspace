package kr.or.kosta.sjrent.model.controller;

import java.util.List;

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
public class ModelSearchController implements Controller {
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

		
		String startDate = request.getParameter("rent_start_date");
		String endDate = request.getParameter("rent_end_date");
		String type = request.getParameter("model_type");

		if (type.equals("all"))
			type = null;

		// 인자로 받은 date와 type
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(type);

		// 검색 인자를 Params에 저장
		ModelParams modelParams = new ModelParams();
		modelParams.setStartDate(startDate);
		modelParams.setEndDate(startDate);
		modelParams.setType(type);

		List<Model> list = null;
		try {
			// Params로 검색한 리스트를 list에 저장
			list = modelService.listBySearch(modelParams);
			// 저장한 리스트를 mav에 추가
			mav.addObject("list", list);
			// rent/search.jsp로 이동
			// 뷰에서 include로 처리하는 것이 좋을 듯
			mav.setView("/index.jsp");
			System.out.println("DD");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}

}

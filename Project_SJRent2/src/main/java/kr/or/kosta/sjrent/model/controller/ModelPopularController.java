package kr.or.kosta.sjrent.model.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.service.ModelService;
import kr.or.kosta.sjrent.model.service.ModelServiceImpl;

/**
 * 대여가 가장 많이 된 상위 searchNum개 모델을 가져오는 컨트롤러
 * 
 * @author 유예겸
 *
 */
public class ModelPopularController implements Controller {
	private ModelService modelService;
	private ModelAndView mav;
	private XMLObjectFactory factory;
	private static final int searchNum = 5;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		List<Model> list = null;

		try {
			list = modelService.PopularModel(searchNum);
			mav.addObject("list", list);
			mav.setView("/rent/rank_list.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}

}
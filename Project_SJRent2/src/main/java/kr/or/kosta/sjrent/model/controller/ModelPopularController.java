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
	private JSONArray jsonArray;
	private static final int searchNum = 5;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		jsonArray = new JSONArray();

		List<Model> list = null;

		try {
			list = modelService.PopularModel(searchNum);
			for (Model model : list) {
				JSONObject modelObject = new JSONObject();
				modelObject.put("name", model.getName());
				modelObject.put("fuelType", model.getFuelType());
				modelObject.put("fuelEfficiency", model.getFuelEfficiency());
				modelObject.put("seater", model.getSeater());
				modelObject.put("transmission", model.getTransmission());
				modelObject.put("navigation", model.getNavigation());
				modelObject.put("cameraRear", model.getCameraRear());
				modelObject.put("year", model.getYear());
				modelObject.put("highpass", model.getHighpass());
				modelObject.put("blackBox", model.getBlackBox());
				modelObject.put("options", model.getOption());
				modelObject.put("picture", model.getPicture());
				modelObject.put("type", model.getType());
				modelObject.put("weekdayPrice", model.getWeekdayPrice());
				modelObject.put("weekendPrice", model.getWeekendPrice());
				modelObject.put("evalScore", model.getEvalScore());
				modelObject.put("rentalCount", model.getRentalCount());
				modelObject.put("reviewCount", model.getReviewCount());
				jsonArray.add(modelObject);
			}
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(jsonArray);
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}

}
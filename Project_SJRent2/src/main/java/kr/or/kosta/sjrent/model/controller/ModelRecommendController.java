package kr.or.kosta.sjrent.model.controller;

import java.io.IOException;
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
 * 추천 차량 display
 * @author 남수현
 */
public class ModelRecommendController implements Controller {
	private ModelService modelService;
	private ModelAndView mav;
	private XMLObjectFactory factory;
	private JSONObject obj;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		obj = new JSONObject();
		String result = request.getParameter("result");
		Model resultModel = null;
		try {
			resultModel = modelService.recommend(result);
		} catch (Exception e1) {
			System.out.println(e1);
		}
		if(resultModel!=null) {
			obj.put("modelName", resultModel.getName());
			obj.put("picture", resultModel.getPicture());
		}
		try {
			response.getWriter().print(obj);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
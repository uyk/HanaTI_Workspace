package kr.or.kosta.sjrent.model.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.params.ModelParams;
import kr.or.kosta.sjrent.model.service.ModelService;
import kr.or.kosta.sjrent.model.service.ModelServiceImpl;

public class ModelListController implements Controller{
	private ModelService modelService;
	private JSONObject obj;
	private ModelAndView mav;
	private XMLObjectFactory factory;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		obj = new JSONObject();
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		System.out.println("model List");
		System.out.println(request.getParameter("date"));
		System.out.println(request.getParameter("type"));
		ModelParams modelParams = new ModelParams();
		List<Model> list = null;
		try {
			list = modelService.listBySearch(modelParams);
			mav.addObject("list", list);
			mav.setView("/rent/search.jsp");
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mav;
	}

}

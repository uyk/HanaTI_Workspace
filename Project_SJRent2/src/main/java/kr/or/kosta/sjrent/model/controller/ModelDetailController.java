package kr.or.kosta.sjrent.model.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.service.ModelService;
import kr.or.kosta.sjrent.model.service.ModelServiceImpl;

/**
 * 모델 이름을 인자로 받아 특정 모델의 상세 정보를 View로 보내는 컨트롤러
 * 
 * @author 유예겸
 *
 */
public class ModelDetailController implements Controller{
	private ModelService modelService;
	private ModelAndView mav;
	private XMLObjectFactory factory;
	private Logger logger = Logger.getLogger(ModelDetailController.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		// 인자로 받는 차 종 이름
		String modelName = request.getParameter("model_name");
		String weekday = request.getParameter("weekday");
		String weekend = request.getParameter("weekend");
		if(modelName == null || weekday == null || weekend == null) {
			logger.debug("파라미터 오류 modelName : " + modelName);
			logger.debug("파라미터 오류 weekday : " + weekday);
			logger.debug("파라미터 오류 weekend : " + weekend);
			return null;
		}
		logger.debug("modelName : " + modelName);
		logger.debug("weekday : " + weekday);
		logger.debug("weekend : " + weekend);
		try {
			Model model = modelService.read(modelName);
			// 전체 리뷰 목록도 반환해야함(mapper 구현 아직 안됨)
			mav.addObject("model", model);
			mav.addObject("weekday", Integer.parseInt(weekday));
			mav.addObject("weekend", Integer.parseInt(weekend));
			mav.setView("/rent/search_detail.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}

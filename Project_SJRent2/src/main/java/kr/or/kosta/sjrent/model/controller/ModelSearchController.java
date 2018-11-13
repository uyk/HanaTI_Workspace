package kr.or.kosta.sjrent.model.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.converter.ObjectToJson;
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
	private JSONArray jsonArray;
	private ObjectToJson otj;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		jsonArray = new JSONArray();
		otj = new ObjectToJson();
		
		String startDate = request.getParameter("rent_start_date");
		String endDate = request.getParameter("rent_end_date");
		String type = request.getParameter("model_type");
		if(type == null) {
			type="all";
		}
		// 인자로 받은 date와 type
		if (type.equals("all"))
			type = null;


		// 검색 인자를 Params에 저장
		ModelParams modelParams = new ModelParams();
		modelParams.setStartDate(startDate);
		modelParams.setEndDate(endDate);
		modelParams.setType(type);
		
		String fuelType = request.getParameter("fuelType");
		String seaterS = request.getParameter("seater");
		String transmission = request.getParameter("transmission");
		String navigationS = request.getParameter("navigation");
		String cameraReaerS = request.getParameter("cameraRear");
		String blackBoxS = request.getParameter("blackBox");
		String highpassS = request.getParameter("highpass");

		if(seaterS!=null) {
			modelParams.setSeater(Integer.parseInt(seaterS));
		}else{
			modelParams.setSeater(-1);
		}
		if(navigationS!=null) {
			modelParams.setNavigation(Integer.parseInt(navigationS));
		}else {
			modelParams.setNavigation(-1);
		}
		if(cameraReaerS!=null) {
			modelParams.setCameraRear(Integer.parseInt(cameraReaerS));
		}else {
			modelParams.setCameraRear(-1);
		}
		if(blackBoxS!=null) {
			modelParams.setBlackBox(Integer.parseInt(blackBoxS));
		}else {
			modelParams.setBlackBox(-1);
		}
		if(highpassS!=null) {
			modelParams.setHighpass(Integer.parseInt(highpassS));
		}else {
			modelParams.setHighpass(-1);
		}
		modelParams.setFuelType(fuelType);
		modelParams.setTransmission(transmission);
		
		System.out.println(modelParams);
		List<Model> list = null;
		try {
			// Params로 검색한 리스트를 list에 저장
			list = modelService.listBySearch(modelParams);
			for (Model model : list) {
				jsonArray.add(otj.ObjectToJsonObject(model));
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
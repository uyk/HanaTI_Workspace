package kr.or.kosta.sjrent.qna.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.service.QnAService;
import kr.or.kosta.sjrent.qna.service.QnAServiceImpl;


/**
 * qna 삭제 컨트롤러
 * 
 * @author 윤형철
 *
 */

public class QnADeleteController implements Controller {
	private QnAService qnaService;
	private JSONObject obj;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		qnaService = (QnAService) factory.getBean(QnAServiceImpl.class);



		int qna_seq = Integer.parseInt(request.getParameter("qna_seq"));
		boolean isDelete = false;
		
		try {
			isDelete = qnaService.delete(qna_seq);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// QnA 삭제 실패시 응답으로 fail 보냄
		if (isDelete == false) {
			obj.put("result", "fail");
			try {
				response.getWriter().print(obj);
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// QnA 삭제 성공시 응답으로 success 보냄
		else {
			//mav.addObject("qna", qna);
			mav.setView("/qna/qnaDelete.jsp");
			obj.put("result", "success");
		}
		return mav;
	}

}
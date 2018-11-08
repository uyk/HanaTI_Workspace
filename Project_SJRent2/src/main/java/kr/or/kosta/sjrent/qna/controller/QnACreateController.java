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
 * qna 생성 컨트롤러
 * 
 */

public class QnACreateController implements Controller {
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


//		int qna_seq = Integer.parseInt(request.getParameter("qna_seq"));
//		int user_seq = Integer.parseInt(request.getParameter("user_seq"));
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String date = request.getParameter("date");
//		String answer = request.getParameter("answer");
		
		
		

		QnA qna = new QnA();
		boolean isCreate = false;
		
		
//		qna.setQna_seq(qna_seq);
//		qna.setUser_seq(user_seq);
		qna.setId(id);
		qna.setTitle(title);
		qna.setContent(content);
		qna.setDate(date);
//		qna.setAnswer(answer);

		System.out.println(qna);
		
		try {
			isCreate = qnaService.create(qna);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// QnA 생성 실패시 응답으로 fail 보냄
		if (isCreate == false) {
			obj.put("result", "fail");
			try {
				response.getWriter().print(obj);
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// QnA 생성 성공시 응답으로 success 보냄
		else {
			mav.addObject("qna", qna);
			mav.setView("/qna/qnaCreate.jsp");
			obj.put("result", "success");
		}
		return mav;
	}

}
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
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;


/**
 * qna 생성 컨트롤러
 * 
 */
public class QnACreateController implements Controller {
	private QnAService qnaService;
	private UserService userService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		qnaService = (QnAService) factory.getBean(QnAServiceImpl.class);
		userService = (UserService) factory.getBean(UserServiceImpl.class);
		
		String loginId = (String) request.getAttribute("loginId");
		//System.out.println("컨트롤럴에서 찍히는 로그인아이디: "+loginId);
		
		User user = new User();
		int userSeq = 0;
		try {
			user = userService.read(loginId);
		} catch (Exception e2) {
			mav.addObject("message", "needLogin");
			mav.setView("/qna/qnaList.jsp");
		}
		if(user!=null) {
			userSeq = user.getSeq();
		}else {
			mav.addObject("message", "needLogin");
			mav.setView("/qna/qnaList.jsp");
		}
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String answer = request.getParameter("answer");
		QnA qna = new QnA();
		qna.setUserSeq(userSeq);
		qna.setUserId(loginId);
		qna.setTitle(title);
		qna.setContent(content);
		qna.setAnswer(answer);
		boolean isCreate = false;
		System.out.println(qna);
		try {
			isCreate = qnaService.create(qna);
			System.out.println("게시글 잘 생성됨............");
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("에러남............");

		}

		// QnA 생성 실패시 응답으로 fail 보냄
		if (isCreate == false) {
			try {
				response.getWriter().print("fail");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// QnA 생성 성공시 응답으로 success 보냄
		else {
			mav.addObject("qna", qna);
			mav.setView("/qna/qnaList.jsp");
			try {
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mav;
	}

}
package kr.or.kosta.sjrent.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.exception.RentException;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.common.fileRename.ReviewFileRename;
import kr.or.kosta.sjrent.common.listener.ServletContextLoadListener;
import kr.or.kosta.sjrent.review.domain.Review;
import kr.or.kosta.sjrent.review.service.ReviewService;
import kr.or.kosta.sjrent.review.service.ReviewServiceImpl;
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;

/**
 * Review add 처리
 * @author 남수현
 */
public class ReviewAddController implements Controller {
	private XMLObjectFactory factory;
	private ReviewService reviewService;
	private UserService userService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		reviewService = (ReviewService) factory.getBean(ReviewServiceImpl.class);
		userService = (UserService) factory.getBean(UserServiceImpl.class);
		User user = new User();
		String loginId = (String) request.getAttribute("loginId");
		try {
			user = userService.read(loginId);
		} catch (Exception e1) {
			throw new RentException("is not logined page");
		}	
		String uploadPath = ServletContextLoadListener.class.getResource("").getPath();
		uploadPath = uploadPath.substring(0,uploadPath.indexOf("/WEB-INF"))+"/images/review";
		String modelName = null;
		String title = null;
		String content = null;
		String picture = null;
		String evalScoreS = null;
		int size = 10*1024*1024;
		ReviewFileRename rfr = new ReviewFileRename();
		rfr.setUserSeq(user.getSeq());
		try{
		    MultipartRequest multi=new MultipartRequest(request,uploadPath,size,"utf-8",new DefaultFileRenamePolicy());
			modelName = multi.getParameter("modelName");
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			picture = multi.getParameter("picture");
			evalScoreS = multi.getParameter("evalScore");
		    Enumeration files = multi.getFileNames();
		    String file = (String)files.nextElement();
		    picture = multi.getFilesystemName(file);
		}catch(Exception e){
		    e.printStackTrace();
		}
		
		int evalScore = 0;
		if (evalScoreS != null && !evalScoreS.equals("")) {
			evalScore = Integer.parseInt(evalScoreS);
		}

		int userNumber = user.getSeq();
		String userId = user.getId();

		Review review = new Review();
		review.setUserNumber(userNumber);
		review.setUserId(userId);
		review.setTitle(title);
		review.setPicture(picture);
		review.setModelName(modelName);
		review.setEvalScore(evalScore);
		review.setContent(content);

		try {
			if (reviewService.create(review)) {
				mav.addObject("message", "create_success");
			} else {
				mav.addObject("message", "create_fail");
			}
		} catch (Exception e) {
			mav.addObject("message", "create_error:"+e);
		}
		mav.setView("/mypage/myReviewList.jsp");
		return mav;
	}

}

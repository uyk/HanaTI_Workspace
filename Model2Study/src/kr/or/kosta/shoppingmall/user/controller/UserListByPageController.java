package kr.or.kosta.shoppingmall.user.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;
import kr.or.kosta.shoppingmall.common.service.ServiceFactory;
import kr.or.kosta.shoppingmall.user.domain.User;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;

public class UserListByPageController implements Controller {
	private UserService userService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		ServiceFactory factory = (ServiceFactory)request.getServletContext().getAttribute("serviceFactory");
		userService = (UserService)(factory.getService(UserServiceImpl.class));
		List<User> list = null;
		try {
			list = userService.list();
		} catch (Exception e) {
			throw new ServletException("UserListByPageController UserService.list() 예외 발생", e);
		}
		
		mav.addObject("list", list);
		mav.setView("/user/listByPage.jsp");
		return mav;
	}
	
	private void setPage(HttpServletRequest request, HttpServletResponse response) {

		// 페이지당 보여지는 목록수 설정
		int listSize = 2;

		// 선택페이지 수신
		String requestPage = request.getParameter("page");
		if(requestPage == null || requestPage.equals("")){
		  requestPage = "1";
		}

		// 검색 요청일 경우 파라메터 수신
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		if(searchType == null || searchType.equals("")){
		  searchType = null;
		  searchValue = null;
		}

		//DaoFactory factory = new JdbcDaoFactory();
		DaoFactory factory = (DaoFactory)application.getAttribute("daoFactory");
		UserDao dao = factory.getUserDao();
		//List<User> list = dao.listAll();
		//List<User> list = dao.listByPage(Integer.parseInt(requestPage));
		//List<User> list = dao.listByPage(Integer.parseInt(requestPage), listSize);
		List<User> list = dao.listByPage(Integer.parseInt(requestPage), listSize, searchType, searchValue); 

		// 페이징 처리에 필요한 검색 개수 DB조회
		int rowCount = dao.countBySearch(searchType, searchValue);

		// 페이지 개수
		int pageCount = (int)Math.ceil((double)rowCount / listSize);


		// 페이지 목록의 시작페이지번호와 마지막페이지번호 계산
		// 목록별 번호
		int pageSize = 5;
		int listNo = (Integer.parseInt(requestPage) - 1) / pageSize; // 목록 식별번호
		//(1~10): 0, (11~20): 1, (21~30): 2, .....

		int startPage = (listNo * pageSize) + 1;
		int endPage = (listNo * pageSize) + pageSize;

		if (endPage > pageCount){
		  endPage = pageCount;
		}
	}

}

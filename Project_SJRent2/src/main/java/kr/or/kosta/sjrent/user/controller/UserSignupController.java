package kr.or.kosta.sjrent.user.controller;

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
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;
import sun.nio.cs.HistoricallyNamedCharset;

/**
 * 로그인 역할을 수행하는 컨트롤러
 * 
 * @author 윤형철
 *
 */

public class UserSignupController implements Controller {
	private UserService userService;
	private JSONObject obj;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);

		
		User user = new User();
		boolean isCreate = false;

		
		// 회원가입시에 들어오는 param
		if(request.getParameter("id") != null) {
			
			
					
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String email = email1 + "@" + email2; 
			String password = request.getParameter("password1");
			
			String birthday = request.getParameter("birthday");
			int point = 10000;
			int gender = Integer.parseInt(request.getParameter("gender"));
			String cellphone1 = request.getParameter("cellphone1");
			String cellphone2 = request.getParameter("cellphone2");
			String cellphone3 = request.getParameter("cellphone3");
			String cellphone = cellphone1 + "-" + cellphone2 + "-" + cellphone3; 
			int isUser = 1;
			
					
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setBirthday(birthday);
			user.setGender(gender);
			user.setCellphone(cellphone);
			user.setIsUser(isUser);
			user.setPoint(point);
			
			
			System.out.println("회원가입요청: " + user);
			
			try {
				isCreate = userService.create(user);
			} catch (Exception e1) {
				e1.printStackTrace();
				
			}

			// 회원가입 실패시 응답으로 fail 보냄
			if (isCreate == false) {
				obj.put("result", "fail");
				try {
					response.sendRedirect("/sjrent/user/regist.jsp");
					//response.getWriter().print(obj);
					return null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			// 회원가입 성공시 응답으로 success 보냄
			else {
				obj.put("result", "success");
				mav.addObject("id", id);
				mav.addObject("email", email);
				mav.addObject("cellphone", cellphone);
				mav.addObject("name", name);

				mav.setView("/user/regist_result.jsp");	
				
				return mav;
			}
			
		}
		// 비회원일때 들어오는 param
		else {
			
			String name_non = request.getParameter("name_non");
			String email_non = request.getParameter("email_non");
			String cellphone_non = request.getParameter("cellphone_non");
			int isUser = 0;
			
			//비회원 이메일 유무 체크
			try {
				user = userService.readByEmail(email_non);
				// 유저가 DB에 없을때 create 
				if(user == null) {
					
					user = new User();
					user.setName(name_non);
					user.setEmail(email_non);
					user.setCellphone(cellphone_non);
					user.setIsUser(isUser);
					
					isCreate = userService.create(user);
					
					// 비회원이 잘 만들어진 경우, index.jsp
					if (isCreate == true) {
						
						obj.put("result", "success");
						mav.addObject("loginId", name_non);
						mav.setView("/index.jsp");
						//return mav;
					}
					// 비회원 생성이 실패시 login2.jsp
					else {
						
						obj.put("result", "fail");
						try {
							response.sendRedirect("/sjrent/user/login2.jsp");
							//response.getWriter().print(obj);
							return null;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}		
				}
				
				
				// 유저가 DB에 있을때 update
				else {
					boolean isUpdate = false;
					
					user.setName(name_non);
					user.setEmail(email_non);
					user.setCellphone(cellphone_non);
									
					isUpdate = userService.update(user);

					// user_seq를 가져와서 해당 update
					if(isUpdate) {
						obj.put("result", "success");
						mav.addObject("loginId", name_non);
						mav.setView("/index.jsp");
						//return mav;
					}
					// 실패하면 login2.jsp로 보내
					else {
						
						obj.put("result", "fail");
						try {
							response.sendRedirect("/sjrent/user/login2.jsp");
							//response.getWriter().print(obj);
							return null;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				

				
				// 쿠키에 longinId 올리기
				String loginId = user.getId();
				
				System.out.println("seq나와라!!!!!!!"+loginId);
				
				Cookie cookie = null;
				cookie = new Cookie("loginId", loginId);
				cookie.setMaxAge(60*60*24*30);
				cookie.setPath("/");
				response.addCookie(cookie);
				
				
				// 결제시 비회원id, seq 보내줘야할 정보
				//request.setAttribute("loginId", userName);			
				mav.addObject("loginId", loginId);
				mav.setView("/sjrent/rent/rent.jsp");
				
				return mav;
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return mav;
	}

}
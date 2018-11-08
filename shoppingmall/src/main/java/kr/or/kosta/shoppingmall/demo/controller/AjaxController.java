package kr.or.kosta.shoppingmall.demo.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;

public class AjaxController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		String num1 = request.getParameter("num1");
		if(num1 == null)  num1 = "0";
		String num2 = request.getParameter("num2");
		if(num2 == null)  num2 = "0";

		int op1 = Integer.parseInt(num1);
		int op2 = Integer.parseInt(num2);
		String operator = request.getParameter("operator");

		int result = 0;
		switch(operator){
		  //case "+" : result = op1 + op2; break;
		  case "-" : result = op1 - op2; break;
		  case "*" : result = op1 * op2; break;
		  case "/" : result = op1 / op2; break;
		  default  : result = op1 + op2; break;
		}
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(result);
		} catch (IOException e) {
			throw new ServletException(e.getMessage(),e);
		}
		return null;
	}

}







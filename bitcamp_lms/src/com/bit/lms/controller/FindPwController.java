package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.FindPwDao;
import com.bit.lms.model.FindPwDto;

@WebServlet("/lms/find_pw.html")
public class FindPwController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher rd=req.getRequestDispatcher("find_pw.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id=req.getParameter("findpw_id");
		String question=req.getParameter("findpw_question");
		String answer=req.getParameter("findpw_answer");
		String pw=req.getParameter("findpw_pw");
		
		FindPwDao dao=new FindPwDao();
		FindPwDto beanID=dao.checkID(id);
		FindPwDto beanQA=dao.checkQA(question, answer);
		int cntPW=dao.updatePW(pw);
		
		if(cntPW>0){
			resp.sendRedirect("login.html");
		}else{
			resp.sendRedirect("find_pw.html");
		}
	}
}

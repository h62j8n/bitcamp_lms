package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.LoginDao;
import com.bit.lms.model.LoginDto;

@WebServlet("/lms/login.html")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		session.setAttribute("findid", null);
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("loginid").trim();
		String pw=req.getParameter("loginpw").trim();
		
		LoginDao dao=new LoginDao();
		LoginDto bean=dao.login(id, pw);
		HttpSession session=req.getSession();
		if(bean.getCnt()>0){
			session.setAttribute("login", bean);
			
			//회원 직원 수정 해야함
			resp.sendRedirect("index.html");
		}else{
			resp.sendRedirect("login.html");
		}
		
	}
}

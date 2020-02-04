package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lms/index_student2.html")
public class IndexStudent2Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("index_student2.jsp");
		rd.forward(req, resp);
		
		//Session
		HttpSession session=req.getSession();
		System.out.println(session.getId());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		/*session.setAttribute("login", null);
		session.removeAttribute("login");*/
		session.invalidate();//세션갱신
		resp.sendRedirect("login.html");
	}
}

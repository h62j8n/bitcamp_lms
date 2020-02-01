package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.JoinDao;
import com.bit.lms.model.JoinDto;

@WebServlet("/lms/join.html")
public class JoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("join.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("join_id").trim();
		String pw=req.getParameter("join_pw").trim();
		String name=req.getParameter("join_name").trim();
		String tel=req.getParameter("join_tel").trim();
		String question=req.getParameter("join_question").trim();
		String answer=req.getParameter("join_answer").trim();
		
		JoinDao dao=new JoinDao();
		int result=dao.insertJoin(name, id, pw, tel, question, answer);
		if(result>0){
			resp.sendRedirect("login.html");
		}else{
			//유효성 검사 후 삭제?
			resp.sendRedirect("join.html");
		}
	}
}

package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.ProfileDao;

@WebServlet("/lms/profile.html")
public class ProfileController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher rd=req.getRequestDispatcher("profile.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String pw=req.getParameter("profilePw").trim();
		String tel=req.getParameter("profileTel").trim();
		String question=req.getParameter("profileQuestion").trim();
		String answer=req.getParameter("profileAnswer").trim();
		String id=req.getParameter("profileId").trim();
		String name=req.getParameter("profileName").trim();
		
		HttpSession session=req.getSession();
		ProfileDao dao=new ProfileDao();
		int result=dao.updateOne(pw, tel, question, answer, id, name);
		if(result>0){
			resp.sendRedirect("profile.html?result="+result);
		}else{
			resp.sendRedirect("profile.html?result="+result);
		}
	}
}

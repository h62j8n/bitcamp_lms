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
import com.bit.lms.model.MyCurriculumDao;

@WebServlet("/lms/index.html")
public class LmsIndexController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Session
		HttpSession session=req.getSession();
		System.out.println(session.getId());
		
		//parameter setting
		LoginDto login =(LoginDto)session.getAttribute("login");
		int mb_no=login.getMbNo();
		
		//MODEL
		MyCurriculumDao dao=new MyCurriculumDao();
		req.setAttribute("mycurriculum", dao.selectOne(mb_no));
		
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();//세션갱신
		resp.sendRedirect("login.html");
	}
}

package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.TeacherNoticeAddDao;
 @WebServlet("/lms/teachernoticeadd.html")
public class TeacherNoticeAddController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("teachernoticeadd.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String param1=req.getParameter("cls_subject");
		String param2=req.getParameter("cls_content");
		System.out.println(param1);
		System.out.println(param2);
		String cls_subject=param1.trim();
		String cls_content=param2.trim();
		
		TeacherNoticeAddDao dao=new TeacherNoticeAddDao();
		dao.insertOne(cls_subject,cls_content);
		resp.sendRedirect("teachernotice.html");
	}
}

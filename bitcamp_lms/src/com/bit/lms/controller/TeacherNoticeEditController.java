package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.TeacherNoticeEditDao;

@WebServlet("/lms/teachernoticeedit.html")
public class TeacherNoticeEditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int cls_no=Integer.parseInt(req.getParameter("idx"));
		
		TeacherNoticeEditDao dao=new TeacherNoticeEditDao();
		req.setAttribute("teachernoticeedit", dao.selectOne(cls_no));
		
		RequestDispatcher rd=req.getRequestDispatcher("teachernoticeedit.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String param1=req.getParameter("cls_no");
		String param2=req.getParameter("cls_subject");
		String param3=req.getParameter("cls_content");
		
		int cls_no=Integer.parseInt(param1.trim());
		String cls_subject=param2.trim();
		String cls_content=param3.trim();
		
		TeacherNoticeEditDao dao=new TeacherNoticeEditDao();
		dao.updateOne(cls_no,cls_subject, cls_content);
		
		resp.sendRedirect("teachernoticedetail.html?idx="+cls_no);
	}
}

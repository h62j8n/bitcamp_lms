package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.TeacherNoticeDeleteDao;

@WebServlet("/teachernoticedelete.html")
public class TeacherNoticeDeleteController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int cls_no=Integer.parseInt(req.getParameter("idx"));
		TeacherNoticeDeleteDao dao=new TeacherNoticeDeleteDao();
		dao.deleteOne(cls_no);
		resp.sendRedirect("lms/teachernotice.html");
	}
}

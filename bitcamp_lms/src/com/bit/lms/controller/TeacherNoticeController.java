package com.bit.lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.TeacherNoticeDao;
import com.bit.lms.model.TeacherNoticeDto;

@WebServlet("/lms/teachernotice.html")
public class TeacherNoticeController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	TeacherNoticeDao dao=new TeacherNoticeDao();
	ArrayList<TeacherNoticeDto> list=dao.TeacherNoticeSelectAll();
	req.setAttribute("teachernoticelist", list);
	RequestDispatcher rd=req.getRequestDispatcher("teachernotice.jsp");
	rd.forward(req, resp);
	
}
}

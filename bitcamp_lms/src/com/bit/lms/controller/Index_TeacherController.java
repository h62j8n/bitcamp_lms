package com.bit.lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.Index_TeacherDao;
import com.bit.lms.model.Index_TeacherDto;

@WebServlet("/lms/index_teacher.html")
public class Index_TeacherController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Index_TeacherDao dao=new Index_TeacherDao();
		ArrayList<Index_TeacherDto> list=dao.Index_TeacherSelectAll();
		req.setAttribute("index_teacherlist", list);
		
		RequestDispatcher rd=req.getRequestDispatcher("index_teacher.jsp");
		rd.forward(req, resp);
	}
}

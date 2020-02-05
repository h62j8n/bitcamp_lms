package com.bit.lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.TeacherScoreDao;
import com.bit.lms.model.TeacherScoreDto;

@WebServlet("/lms/teacherscore.html")
public class TeacherScoreController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TeacherScoreDao dao=new TeacherScoreDao();
		ArrayList<TeacherScoreDto> list=dao.TeacherScoreSelectAll();
		req.setAttribute("teacherscorelist", list);
		RequestDispatcher rd=req.getRequestDispatcher("teacherscore.jsp");
		rd.forward(req, resp);
	}
	
}

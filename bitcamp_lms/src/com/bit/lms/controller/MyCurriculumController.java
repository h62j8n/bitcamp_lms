package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.MyCurriculumDao;

@WebServlet("/lms/mycurriculum.html")
public class MyCurriculumController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//parameter setting
		String param=req.getParameter("no");
		int mb_no=Integer.parseInt(param);
		
		//MODEL
		MyCurriculumDao dao=new MyCurriculumDao();
		req.setAttribute("mycurriculum", dao.selectOne(mb_no));
		
		//VIEW
		RequestDispatcher rd = req.getRequestDispatcher("mycurriculum.jsp");
		rd.forward(req, resp);
	}
}

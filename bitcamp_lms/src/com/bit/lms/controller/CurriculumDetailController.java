package com.bit.lms.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.home.model.EducurriDetailDao;
import com.bit.home.model.EducurriculumDao;
import com.bit.home.model.EducurriculumDto;
import com.bit.util.Paging;

@WebServlet("/lms/curriculum_detail.html")
public class CurriculumDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param=req.getParameter("idx");
		int recr_no=Integer.parseInt(param);
		
		//MODEL
		EducurriDetailDao dao=new EducurriDetailDao();
		req.setAttribute("recr_detail", dao.selectOne(recr_no));
				
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("curriculum_detail.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		/*session.setAttribute("login", null);
		session.removeAttribute("login");*/
		session.invalidate();//세션갱신
		resp.sendRedirect("login.html");
	}
}

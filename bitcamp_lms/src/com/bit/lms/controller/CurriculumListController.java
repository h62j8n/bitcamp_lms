package com.bit.lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.home.model.EducurriculumDao;
import com.bit.home.model.EducurriculumDto;
import com.bit.util.Paging;

@WebServlet("/lms/curriculum_list.html")
public class CurriculumListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EducurriculumDao dao=new EducurriculumDao();
		
		int page=1;
		if(req.getParameter("page")!=null){
			page=Integer.parseInt(req.getParameter("page"));
		}
		int count=dao.getAllCount();
		
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setTotalCount(count);
		
		ArrayList<EducurriculumDto> list=dao.selectAll(paging);
		
		req.setAttribute("educurriculumlist", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("curriculum_list.jsp");
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

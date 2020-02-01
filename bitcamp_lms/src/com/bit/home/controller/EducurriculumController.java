package com.bit.home.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.LecDao;
import com.bit.lms.model.LecDto;
import com.bit.home.model.EducurriculumDao;
import com.bit.home.model.EducurriculumDto;
import com.bit.home.model.IndexDao;
import com.bit.home.model.IndexDto;
import com.bit.util.Paging;

@WebServlet("/home/educurriculum.html")
public class EducurriculumController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//MODEL,paging
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
		req.setAttribute("paging", paging);
		
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("educurriculum.jsp");
		rd.forward(req, resp);
	}
}
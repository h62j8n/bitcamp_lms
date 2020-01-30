package com.bit.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.LecDao;
import com.bit.emp.model.LecDto;
import com.bit.main.model.EducurriculumDao;
import com.bit.main.model.EducurriculumDto;
import com.bit.main.model.IndexDao;
import com.bit.main.model.IndexDto;
import com.bit.util.Paging;

@WebServlet("/main/educurriculum.html")
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
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setTotalCount(44);
		
		ArrayList<EducurriculumDto> list=dao.selectAll(page);
		
		req.setAttribute("educurriculumlist", list);
		req.setAttribute("paging", paging);
		
		/*LecDao lecdao=new LecDao();
		ArrayList<LecDto> leclist=lecdao.selectAll();
		req.setAttribute("leclist", leclist);*/
		
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("educurriculum.jsp");
		rd.forward(req, resp);
	}
}

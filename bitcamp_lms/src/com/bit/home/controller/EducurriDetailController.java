package com.bit.home.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.home.model.EducurriDetailDao;


@WebServlet("/home/educurridetail.html")
public class EducurriDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param=req.getParameter("idx");
		int recr_no=Integer.parseInt(param);
		
		//MODEL
		EducurriDetailDao dao=new EducurriDetailDao();
		req.setAttribute("recr_detail", dao.selectOne(recr_no));
				
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("educurridetail.jsp");
		rd.forward(req, resp);
	}
}

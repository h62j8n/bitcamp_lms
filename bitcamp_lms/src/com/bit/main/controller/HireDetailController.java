package com.bit.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.main.model.HireDetailDao;
import com.bit.main.model.HireDetailDto;

@WebServlet("/main/hiredetail.html")
public class HireDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int job_no=Integer.parseInt(req.getParameter("idx"));
		
		HireDetailDao dao=new HireDetailDao();
		req.setAttribute("hiredetail", dao.selectOne(job_no));
		
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("hiredetail.jsp");
		rd.forward(req, resp);
	}
}

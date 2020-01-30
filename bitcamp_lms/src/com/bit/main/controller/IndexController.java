package com.bit.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.main.model.IndexDao;
import com.bit.main.model.IndexDto;

public class IndexController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//MODEL
		IndexDao dao=new IndexDao();
		ArrayList<IndexDto> list=dao.selectAll();
		req.setAttribute("indexlist", list);
		
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
}

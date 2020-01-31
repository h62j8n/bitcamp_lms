package com.bit.home.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.home.model.FAQDao;
import com.bit.home.model.FAQDto;

@WebServlet("/home/faq.html")
public class FAQController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		FAQDao dao=new FAQDao();
		ArrayList<FAQDto> list=dao.FAQSelectAll();
		req.setAttribute("faqlist", list);
		RequestDispatcher rd=req.getRequestDispatcher("faq.jsp");
		rd.forward(req, resp);
		
	}
	
}

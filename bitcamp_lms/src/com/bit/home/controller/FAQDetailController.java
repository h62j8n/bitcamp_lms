package com.bit.home.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.home.model.FAQDetailDao;
@WebServlet("/home/faqdetail.html")
public class FAQDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int faq_no=Integer.parseInt(req.getParameter("idx"));
		
		FAQDetailDao dao=new FAQDetailDao();
		req.setAttribute("faqdetaillist", dao.selectOne(faq_no));
		
		RequestDispatcher rd=req.getRequestDispatcher("faqdetail.jsp");
		rd.forward(req, resp);
	}
}

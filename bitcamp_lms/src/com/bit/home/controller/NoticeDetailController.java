package com.bit.home.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.home.model.NoticeDetailDao;


@WebServlet("/home/noticedetail.html")
public class NoticeDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int ntc_no=Integer.parseInt(req.getParameter("idx"));
		
		NoticeDetailDao dao=new NoticeDetailDao();
		req.setAttribute("noticedetail", dao.selectOne(ntc_no));
		
		RequestDispatcher rd=req.getRequestDispatcher("noticedetail.jsp");
		rd.forward(req, resp);
	}
}

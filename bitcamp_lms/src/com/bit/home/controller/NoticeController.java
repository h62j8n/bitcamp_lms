package com.bit.home.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.home.model.NoticeDao;
import com.bit.home.model.NoticeDto;
@WebServlet("/home/notice.html")
public class NoticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		NoticeDao dao=new NoticeDao();
		ArrayList<NoticeDto> list=dao.NoticeSelectAll();
		req.setAttribute("noticelist", list);
		RequestDispatcher rd=req.getRequestDispatcher("notice.jsp");
		rd.forward(req, resp);
	}
}

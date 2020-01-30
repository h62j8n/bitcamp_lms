package com.bit.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.main.model.HireDao;
import com.bit.main.model.HireDto;

@WebServlet("/main/hire.html")
public class HireController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HireDao dao=new HireDao();
		ArrayList<HireDto> list=dao.HireSelectAll();
		req.setAttribute("hirelist", list);
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("hire.jsp");
		rd.forward(req, resp);
	}
}

package com.bit.lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.Member3Dao;
import com.bit.lms.model.Member3Dto;

@WebServlet("/lms/member3.html")
public class member3Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Member3Dao dao=new Member3Dao();
		ArrayList<Member3Dto> list=dao.applListLec();
		req.setAttribute("recrList", list);
		RequestDispatcher rd=req.getRequestDispatcher("member3.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String param=req.getParameter("lecSta").trim();
		int state=Integer.parseInt(param);
		String id=req.getParameter("lecId").trim();
		
		Member3Dao dao=new Member3Dao();
		int result=dao.updateOne(state, id);
		if(result>0){
			resp.sendRedirect("member3.html?result="+result);
		}else{
			resp.sendRedirect("member3.html?result="+result);
		}
	}
}

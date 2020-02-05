package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.LockDao;
import com.bit.lms.model.LockDto;

@WebServlet("/lms/lock.html")
public class LockController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher rd=req.getRequestDispatcher("lock.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("lockId").trim();
		String pw=req.getParameter("lockPw").trim();
		
		HttpSession session=req.getSession();
		LockDao dao=new LockDao();
		LockDto bean=dao.selectOne(id,pw);
		if(bean.getCnt()>0){
			resp.sendRedirect("lock.html?result="+bean.getCnt());
		}else{
			resp.sendRedirect("lock.html?result="+bean.getCnt());
		}
	}
}

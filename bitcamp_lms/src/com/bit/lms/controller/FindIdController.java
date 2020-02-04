package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.FindidDao;
import com.bit.lms.model.FindidDto;

@WebServlet("/lms/find_id.html")
public class FindIdController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher rd=req.getRequestDispatcher("find_id.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("findid_name").trim();
		String tel=req.getParameter("findid_tel").trim();
		
		FindidDao dao=new FindidDao();
		FindidDto bean=dao.findId(name, tel);
		HttpSession session=req.getSession();
		
		if(bean.getCnt()>0){
			session.setAttribute("findid", bean);
			resp.sendRedirect("find_id.html?result="+bean.getCnt());
		}else{
			resp.sendRedirect("find_id.html?result="+bean.getCnt());
		}
	}
}

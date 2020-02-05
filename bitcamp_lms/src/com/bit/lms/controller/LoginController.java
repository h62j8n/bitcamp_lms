package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.LoginDao;
import com.bit.lms.model.LoginDto;

@WebServlet("/lms/login.html")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		session.setAttribute("dupliId", null);
		session.setAttribute("joinName", null);
		session.setAttribute("findid", null);
		session.setAttribute("findpwID", null);
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id=req.getParameter("loginid").trim();
		String pw=req.getParameter("loginpw").trim();
		
		System.out.println(id);
		System.out.println(pw);
		HttpSession session=req.getSession();
		LoginDao dao=new LoginDao();
		LoginDto bean=dao.login(id, pw);
		System.out.println("1");
		if(bean.getCateNo()>0){
			System.out.println("2");
			LoginDto dept=dao.selectDept(bean.getMbNo(), bean.getCateNo());
			bean.setDeptNo(dept.getDeptNo());
			System.out.println("3");
		}else{
			System.out.println("4");
			LoginDto state=dao.selectState(bean.getMbNo());
			bean.setStaNo(state.getStaNo());
			System.out.println("5");
		}
		System.out.println(bean.getMbNo());
		System.out.println(bean.getCateNo());
		System.out.println(bean.getDeptNo());
		System.out.println(bean.getStaNo());
		if(bean.getCnt()>0){
			session.setAttribute("login", bean);
			resp.sendRedirect("login.html?result="+bean.getCnt());
		}else{
			resp.sendRedirect("login.html?result="+bean.getCnt());
		}
	}
}

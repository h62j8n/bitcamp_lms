package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.AtteDao;
import com.bit.lms.model.LoginDao;
import com.bit.lms.model.LoginDto;
import com.bit.lms.model.MyCurriculumDao;

@WebServlet("/lms/index.html")
public class LmsIndexController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Session
		HttpSession session=req.getSession();
		System.out.println(session.getId());
		
		
		//MODEL
		try{
		//parameter setting
		LoginDto login =(LoginDto)session.getAttribute("login");
		int mb_no=login.getMbNo();
		MyCurriculumDao dao=new MyCurriculumDao();
		req.setAttribute("mycurriculum", dao.selectOne(mb_no));
		//VIEW
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		} catch(NullPointerException e){
			resp.sendRedirect("login.html");
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String param1=null;
		String param2=null;
		String param3=null;
		
		HttpSession session=req.getSession();
		LoginDto login =(LoginDto)session.getAttribute("login");
		int mb_no=login.getMbNo();
		
		if(req.getParameter("logout")!=null){
			param1=req.getParameter("logout").trim();
			if(param1.equals("logout")){
				session.invalidate();//세션갱신
				resp.sendRedirect("login.html");
			}
		}
		if(req.getParameter("atStatus")!=null){
			param2=req.getParameter("atStatus").trim();
			if(param2.equals("입실")){
				System.out.println("입실받아옴");
				if(req.getParameter("atDate")!=null){
					System.out.println("date받아옴");
					param3=req.getParameter("atDate").trim().substring(2);
					AtteDao dao=new AtteDao();
					System.out.println(param3);
					dao.insertAtteIn(mb_no, param3);
					doGet(req,resp);
				}
			}
		}
	}
}

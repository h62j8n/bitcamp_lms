package com.bit.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.FindPwDao;
import com.bit.lms.model.FindPwDto;

@WebServlet("/lms/find_pw.html")
public class FindPwController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher rd=req.getRequestDispatcher("find_pw.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("findpw_id");
		String question=req.getParameter("findpw_question");
		String answer=req.getParameter("findpw_answer");
		String pw=req.getParameter("findpw_pw");
		
		int count=0;
		if(id!=null)count++;
		if(question!="")count++;
		if(answer!="")count++;
		if(pw!="")count++;
		
		HttpSession session=req.getSession();
		FindPwDao dao=new FindPwDao();
		FindPwDto beanID=new FindPwDto();
		FindPwDto beanQA=new FindPwDto();
		int cntPW=0;
		
		if(count==1){
			beanID=dao.checkID(id);
			if(beanID.getCnt_id()>0){
				session.setAttribute("findpwID", beanID);
				resp.sendRedirect("find_pw.html?result_id="+beanID.getCnt_id());
			}else{
				resp.sendRedirect("find_pw.html?result_id="+beanID.getCnt_id());
			}
		}
		if(count==3){
			beanQA=dao.checkQA(question, answer, id);
			if(beanQA.getCnt_qa()>0){
				resp.sendRedirect("find_pw.html?result_qa="+beanQA.getCnt_qa());
			}else{
				resp.sendRedirect("find_pw.html?result_qa="+beanQA.getCnt_qa());
			}
		}
		if(count==2){
			cntPW=dao.updatePW(id, pw);
			if(cntPW>0){
				resp.sendRedirect("find_pw.html?result_pw="+cntPW);
			}else{
				resp.sendRedirect("find_pw.html?result_pw="+cntPW);
			}
		}
	}
}

package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;


public class LoginDao {
	public LoginDto login(String id, String pw){
		String sql="SELECT COUNT(MB_ID) AS \"CNT\", MAX(MB_ID) AS \"ID\"";
		sql+=", MAX(MB_NAME) AS \"NAME\", MAX(MB_TEL) AS \"TEL\"";
		sql+=", MAX(MB_QUESTION) AS \"QUESTION\", MAX(MB_ANSWER) AS \"ANSWER\"";
		sql+=", MAX(MB_NO) AS \"MBNO\", MAX(CATE_NO) AS \"CATENO\"";
		sql+=" FROM MB WHERE MB_ID=? AND MB_PW=?";
		
		LoginDto bean=new LoginDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setTel(rs.getString("tel"));
				bean.setQuestion(rs.getString("question"));
				bean.setAnswer(rs.getString("answer"));
				bean.setCnt(rs.getInt("cnt"));
				bean.setMbNo(rs.getInt("mbno"));
				bean.setCateNo(rs.getInt("cateno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}
	
	public LoginDto selectDept(int mbno, int cateno){
		String sql="select dept_no from ";
		sql+="(select mb_no from mb where mb_no=? and cate_no=?) a";
		sql+=", emp b where a.mb_no=b.mb_no";
		
		LoginDto bean=new LoginDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mbno);
			pstmt.setInt(2, cateno);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setDeptNo(rs.getInt("dept_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}
	
	public LoginDto selectState(int no){
		String sql="select sta_code from appl where mb_no=?";
		
		LoginDto bean=new LoginDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setStaNo(rs.getInt("sta_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}
}

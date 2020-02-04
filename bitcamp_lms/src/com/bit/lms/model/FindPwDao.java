package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;

public class FindPwDao {
	
	public FindPwDto checkID(String id){
		String sql="SELECT COUNT(MB_ID) AS \"CNT\", MAX(MB_ID) AS \"ID\" FROM MB WHERE MB_ID=?";
		
		FindPwDto bean=new FindPwDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setId(rs.getString("id"));
				bean.setCnt_id(rs.getInt("cnt"));
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
	
	public FindPwDto checkQA(String question, String answer, String id){
		String sql="SELECT COUNT(MB_ANSWER) AS \"CNT\" FROM MB WHERE MB_QUESTION=? AND MB_ANSWER=? AND MB_ID=?";
		
		FindPwDto bean=new FindPwDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, question);
			pstmt.setString(2, answer);
			pstmt.setString(3, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setCnt_qa(rs.getInt("cnt"));
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
	
	public int updatePW(String id, String pw){
		String sql="UPDATE MB SET MB_PW=? where mb_id=?";
		
		int result=0;
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}

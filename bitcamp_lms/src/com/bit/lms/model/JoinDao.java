package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;

public class JoinDao {
	
	public int insertJoin(String name, String id, String pw, String tel, String question, String answer){
		
		//회원번호, id, pw, name, tel, question, answer, 구분
		String sql="INSERT INTO MB VALUES(MB_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, DEFAULT)";
		
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, question);
			pstmt.setString(6, answer);
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
	
	public JoinDto selectID(String id){
		
		String sql="SELECT COUNT(MB_ID) AS \"CNT\" FROM MB WHERE MB_ID=?";
		
		JoinDto bean=new JoinDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setCnt(rs.getInt("cnt"));
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
	

	public JoinDto selectOne(String name, String id){
		
		String sql="SELECT COUNT(MB_NAME) AS \"CNT2\", MAX(MB_NAME) AS \"NAME\"";
		sql+=", MAX(MB_NO) AS \"NO\" FROM MB WHERE MB_NAME=? AND MB_ID=?";
		
		JoinDto bean=new JoinDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setName(rs.getString("name"));
				bean.setNo(rs.getInt("no"));
				bean.setCnt2(rs.getInt("cnt2"));
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
	
public int insertAppl(int no){
		
		String sql="INSERT INTO APPL VALUES (?,DEFAULT,NULL,NULL)";
		
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
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

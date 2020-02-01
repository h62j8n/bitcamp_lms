package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}

package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bit.util.BitOracle;

public class ProfileDao {
	
	public int updateOne(String pw, String tel, String question, String answer, String id, String name){
		
		String sql="update mb set mb_pw=?, mb_tel=?, mb_question=?, mb_answer=?";
		sql+=" where mb_id=? and mb_name=?";
		
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, tel);
			pstmt.setString(3, question);
			pstmt.setString(4, answer);
			pstmt.setString(5, name);
			pstmt.setString(6, id);
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

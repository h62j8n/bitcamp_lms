package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;


public class LoginDao {
	public LoginDto login(String id, String pw){
		String sql="SELECT COUNT(MB_ID) AS \"CNT\", MAX(MB_ID) AS \"ID\"";
		sql+=", MAX(MB_PW) AS \"PW\" FROM MB WHERE MB_ID=? AND MB_PW=?";
		
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
				bean.setPw(rs.getString("pw"));
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
}

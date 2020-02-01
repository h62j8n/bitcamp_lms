package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;


public class LoginDao {
	public LoginDto login(String id, String pw){
		String sql="select count(mb_id) as \"cnt\", max(mb_id) as \"id\"";
		sql+=", max(mb_pw) as \"pw\" from mb where mb_id=? and mb_pw=?";
		
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

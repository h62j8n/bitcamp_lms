package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;


public class FindidDao {
	
	public FindidDto findId(String name, String tel){
		String sql="SELECT COUNT(MB_NAME) AS \"CNT\", MAX(MB_ID) AS \"ID\"";
		sql+=" FROM MB WHERE MB_NAME=? AND MB_TEL=?";

		FindidDto bean=new FindidDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setId(rs.getString("id"));
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

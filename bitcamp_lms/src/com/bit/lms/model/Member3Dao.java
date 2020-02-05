package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class Member3Dao {

	public ArrayList<Member3Dto> applListLec(){
		String sql="select a.mb_name, a.mb_id, a.mb_tel, b.sta_code, b.lec_code, c.lec_roomno, c.lec_name from mb a, appl b, lec c where a.mb_no=b.mb_no and b.lec_code=c.lec_code";

		ArrayList<Member3Dto> list=new ArrayList<Member3Dto>();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Member3Dto bean=new Member3Dto();
				bean.setName(rs.getString("mb_name"));
				bean.setId(rs.getString("mb_id"));
				bean.setTel(rs.getString("mb_tel"));
				bean.setStaCode(rs.getInt("sta_code"));
				bean.setLecCode(rs.getString("lec_code"));
				bean.setLecRoomNo(rs.getInt("lec_roomno"));
				bean.setLecName(rs.getString("lec_name"));
				list.add(bean);
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
		return list;
	}
	
	public int updateOne(int staCode){
		String sql="";
		
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
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

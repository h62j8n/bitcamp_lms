package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class Index_TeacherDao {
	public ArrayList<Index_TeacherDto> Index_TeacherSelectAll(){
		String sql="select * from cls_bbs order by cls_no desc";
		
		ArrayList<Index_TeacherDto> list =new ArrayList<Index_TeacherDto>();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Index_TeacherDto bean= new Index_TeacherDto();
				bean.setCls_subject(rs.getString("cls_subject"));
				bean.setCls_date(rs.getDate("cls_date"));
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
}

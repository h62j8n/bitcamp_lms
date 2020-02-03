package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class TeacherNoticeDao {
	public ArrayList<TeacherNoticeDto> TeacherNoticeSelectAll(){
		String sql="select * from cls_bbs order by cls_no desc";
		ArrayList<TeacherNoticeDto> list =null;
		list=new ArrayList<TeacherNoticeDto>();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				TeacherNoticeDto bean=new TeacherNoticeDto();
				bean.setCls_no(rs.getInt("cls_no"));
				bean.setCls_subject(rs.getString("cls_subject"));
				bean.setCls_date(rs.getDate("cls_date"));
				bean.setCls_count(rs.getInt("cls_count"));
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

package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;

public class TeacherNoticeEditDao {

	public  TeacherNoticeEditDto selectOne(int cls_no){
		String sql="select * from cls_bbs where cls_no=?";
		TeacherNoticeEditDto bean=new TeacherNoticeEditDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cls_no);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setCls_no(rs.getInt("cls_no"));
				bean.setCls_subject(rs.getString("cls_subject"));
				bean.setCls_date(rs.getDate("cls_date"));
				bean.setCls_count(rs.getInt("cls_count"));
				bean.setCls_content(rs.getString("cls_content"));
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
	
	public int updateOne(int cls_no,String cls_subject,String cls_content){
		String sql="update cls_bbs set cls_subject=?,cls_content=? where cls_no=?";
		int result=0;
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cls_subject);
			pstmt.setString(2, cls_content);
			pstmt.setInt(3, cls_no);
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

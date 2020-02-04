package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;

public class TeacherNoticeDetailDao {
	public TeacherNoticeDetailDto selectOne(int cls_no){
		String sql="SELECT * FROM CLS_BBS WHERE CLS_NO=?";
		String sqlcount="UPDATE CLS_BBS SET CLS_COUNT=CLS_COUNT+1 WHERE CLS_NO=?";
		
		TeacherNoticeDetailDto bean=new TeacherNoticeDetailDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sqlcount);
			pstmt.setInt(1, cls_no);
			int result=pstmt.executeUpdate();
			if(result>0){
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, cls_no);
				rs=pstmt.executeQuery();
				if(rs.next()){
					bean.setCls_subject(rs.getString("cls_subject"));
					bean.setCls_date(rs.getDate("cls_date"));
					bean.setCls_count(rs.getInt("cls_count"));
					bean.setCls_content(rs.getString("cls_content"));
				}
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

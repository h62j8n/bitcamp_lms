package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bit.util.BitOracle;

public class TeacherNoticeDeleteDao {
	 public int deleteOne(int cls_no){
		   String sql="delete from cls_bbs where cls_no=?";
		   int result=0;
		   
		   Connection conn=BitOracle.getConnection();
		   PreparedStatement pstmt=null;
		   
		   try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cls_no);
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

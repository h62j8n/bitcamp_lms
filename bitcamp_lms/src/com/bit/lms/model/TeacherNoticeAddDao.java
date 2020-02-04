package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bit.util.BitOracle;

public class TeacherNoticeAddDao {
	public void insertOne(String cls_subject,String cls_content){
		String sql="INSERT INTO CLS_BBS VALUES(CLS_SEQ.NEXTVAL,10001,1001,?,?,0,SYSDATE)";
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cls_subject);
			pstmt.setString(2, cls_content);
			pstmt.executeUpdate();
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
	}
}

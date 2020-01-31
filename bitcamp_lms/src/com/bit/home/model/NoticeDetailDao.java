package com.bit.home.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;

public class NoticeDetailDao {
	public NoticeDetailDto selectOne(int ntc_no){
		String sql="select * from ntc_bbs where ntc_no=?";
		String sqlcount="UPDATE NTC_BBS SET NTC_COUNT=NTC_COUNT+1 WHERE NTC_NO=?";

		NoticeDetailDto bean=new NoticeDetailDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sqlcount);
			pstmt.setInt(1, ntc_no);
			int result=pstmt.executeUpdate();
			if(result>0){
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, ntc_no);
				rs=pstmt.executeQuery();
				if(rs.next()){
				bean.setNtc_subject(rs.getString("ntc_subject"));
				bean.setNtc_date(rs.getDate("ntc_date"));
				bean.setNtc_count(rs.getInt("ntc_count"));
				bean.setNtc_content(rs.getString("ntc_content"));
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

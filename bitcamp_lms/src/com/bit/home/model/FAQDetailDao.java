package com.bit.home.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;

public class FAQDetailDao {
	public FAQDetailDto selectOne(int faq_no){
		String sql="select * from faq_bbs where faq_no=?";
		String sqlcount= "UPDATE FAQ_BBS SET FAQ_COUNT=FAQ_COUNT+1 WHERE FAQ_NO=?";
		
		FAQDetailDto bean=new FAQDetailDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sqlcount);
			pstmt.setInt(1, faq_no);
			int result=pstmt.executeUpdate();
			if(result>0){
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, faq_no);
				rs=pstmt.executeQuery();
				if(rs.next()){
					bean.setFaq_subject(rs.getString("faq_subject"));
					bean.setFaq_date(rs.getDate("faq_date"));
					bean.setFaq_count(rs.getInt("faq_count"));
					bean.setFaq_content(rs.getString("faq_content"));
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

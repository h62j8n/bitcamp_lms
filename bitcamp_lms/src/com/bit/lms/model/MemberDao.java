package com.bit.lms.model;

import java.util.ArrayList;

public class MemberDao {
	public ArrayList<MemberDto> MemberSelectAll(){
		ArrayList<MemberDto> list = null;
		return list;
	}
	/*
	public ArrayList<FAQDto> FAQSelectAll(){
		String sql="select * from faq_bbs order by faq_no desc";
		ArrayList<FAQDto> list=new ArrayList<FAQDto>();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				FAQDto bean=new FAQDto();
				bean.setFaq_no(rs.getInt("faq_no"));
				bean.setFaq_subject(rs.getString("faq_subject"));
				bean.setFaq_date(rs.getDate("faq_date"));
				bean.setFaq_count(rs.getInt("faq_count"));
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
	*/
}

package com.bit.home.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class NoticeDao {
	public ArrayList<NoticeDto> NoticeSelectAll(){
		String sql="select * from ntc_bbs order by ntc_no desc";
		ArrayList<NoticeDto> list=null;
		list=new ArrayList<NoticeDto>();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				NoticeDto bean=new NoticeDto();
				bean.setNtc_no(rs.getInt("ntc_no"));
				bean.setNtc_subject(rs.getString("ntc_subject"));
				bean.setNtc_date(rs.getDate("ntc_date"));
				bean.setNtc_count(rs.getInt("ntc_count"));
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

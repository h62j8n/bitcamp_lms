package com.bit.main.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class HireDao {
	
	public ArrayList<HireDto> HireSelectAll(){
		String sql="select * from job_bbs";
		ArrayList<HireDto> list=null;
		list=new ArrayList<HireDto>(0);
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				HireDto bean=new HireDto();
				bean.setJob_no(rs.getInt("job_no"));
				bean.setJob_subject(rs.getString("job_subject"));
				bean.setJob_date(rs.getDate("job_date"));
				bean.setJob_count(rs.getInt("job_count"));
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

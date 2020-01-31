package com.bit.main.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class HireDetailDao {
	
	public HireDetailDto selectOne(int job_no){
		String sql="select * from job_bbs where job_no=?";
		HireDetailDto bean=new HireDetailDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, job_no);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setJob_compname(rs.getString("job_compname"));
				bean.setJob_date(rs.getDate("job_date"));
				bean.setJob_recrnum(rs.getInt("job_recrnum"));
				bean.setJob_emptype(rs.getString("job_emptype"));
				bean.setJob_loc(rs.getString("job_loc"));
				bean.setJob_enddate(rs.getString("job_enddate"));
				bean.setJob_count(rs.getInt("job_count"));
				bean.setJob_content(rs.getString("job_content"));
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

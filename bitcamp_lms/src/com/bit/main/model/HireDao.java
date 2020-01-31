package com.bit.main.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class HireDao {
	
	public ArrayList<HireDto> HireSelectAll(){
		String sql="select * from job_bbs order by job_no desc";
		ArrayList<HireDto> list=null;
		list=new ArrayList<HireDto>();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				HireDto bean=new HireDto();
				bean.setJob_no(rs.getInt("job_no"));
				bean.setJob_compname(rs.getString("job_compname"));
				bean.setJob_loc(rs.getString("job_loc"));
				bean.setJob_recrnum(rs.getInt("job_recrnum"));
				bean.setJob_emptype(rs.getString("job_emptype"));
				bean.setJob_enddate(rs.getString("job_enddate"));
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

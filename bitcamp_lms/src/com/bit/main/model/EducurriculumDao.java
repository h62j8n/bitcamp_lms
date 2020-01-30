package com.bit.main.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class EducurriculumDao {
	public ArrayList<EducurriculumDto> selectAll(){
		String sql="SELECT * FROM RECR_BBS";
		
		ArrayList<EducurriculumDto> list=null;
		list =new ArrayList<EducurriculumDto>();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				EducurriculumDto bean=new EducurriculumDto();
				bean.setRecr_subject(rs.getString("RECR_SUBJECT"));
				bean.setRecr_date(rs.getDate("RECR_DATE"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}

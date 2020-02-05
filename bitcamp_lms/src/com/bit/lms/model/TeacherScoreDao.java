package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class TeacherScoreDao {
	public ArrayList<TeacherScoreDto> TeacherScoreSelectAll(){
		String sql="select * from score";
		ArrayList<TeacherScoreDto> list=new ArrayList<TeacherScoreDto>();
		
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				TeacherScoreDto bean=new TeacherScoreDto();
				bean.setScore_java(rs.getInt("score_java"));
				bean.setScore_fw(rs.getInt("score_fw"));
				bean.setScore_db(rs.getInt("score_db"));
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

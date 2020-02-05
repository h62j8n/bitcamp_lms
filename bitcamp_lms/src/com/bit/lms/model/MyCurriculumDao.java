package com.bit.lms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bit.util.BitOracle;

public class MyCurriculumDao {
	public MyCurriculumDto selectOne(int mbNo){
		String sql="SELECT * FROM LEC WHERE LEC_CODE=(SELECT LEC_CODE FROM APPL WHERE MB_NO = ?)";
		MyCurriculumDto bean = new MyCurriculumDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mbNo);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setLec_name(rs.getString("LEC_NAME"));
				bean.setLec_start(rs.getDate("LEC_START"));
				bean.setLec_end(rs.getDate("LEC_END"));
				bean.setLec_code(rs.getString("LEC_CODE"));
				bean.setLec_roomno(rs.getInt("LEC_ROOMNO"));
				bean.setLec_instructor(rs.getString("LEC_INSTRUCTOR"));
				bean.setLec_applnum(rs.getInt("LEC_APPLNUM"));
				bean.setLec_lecnum(rs.getInt("LEC_LECNUM"));
				bean.setLec_content(rs.getString("LEC_CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
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
	public MyCurriculumDto selectSta(int mbNo){
		String sql="SELECT STA_CODE FROM APPL WHERE MB_NO =?";
		MyCurriculumDto bean = new MyCurriculumDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mbNo);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setSta_code(rs.getInt("STA_CODE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
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
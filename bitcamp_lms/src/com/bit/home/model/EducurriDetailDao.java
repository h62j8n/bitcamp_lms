package com.bit.home.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.BitOracle;

public class EducurriDetailDao {
	
	public EducurriDetailDto selectOne(int recr_no){
		String sql="SELECT A.RECR_NO, A.RECR_COUNT, A.RECR_DATE, B.LEC_NAME";
		sql+=", B.LEC_CONTENT, B.LEC_START, B.LEC_END, B.LEC_APPL_START, B.LEC_APPL_END, B.LEC_LECNUM, B.LEC_APPLNUM, B.LEC_INSTRUCTOR FROM ";
		sql+="(SELECT RECR_NO, RECR_COUNT, RECR_DATE, LEC_CODE FROM RECR_BBS WHERE RECR_NO=?) A";
		sql+=", LEC B WHERE A.LEC_CODE=B.LEC_CODE";
		
		String sqlCount="UPDATE RECR_BBS SET RECR_COUNT=RECR_COUNT+1 WHERE RECR_NO=?";
		
		EducurriDetailDto bean=new EducurriDetailDto();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sqlCount);
			pstmt.setInt(1, recr_no);
			int result=pstmt.executeUpdate();
			if(result>0){
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, recr_no);
				rs=pstmt.executeQuery();
				if(rs.next()){
					bean.setRecr_no(rs.getInt("recr_no"));
					bean.setRecr_count(rs.getInt("recr_count"));
					bean.setRecr_date(rs.getDate("recr_date"));
					bean.setLec_name(rs.getString("lec_name"));
					bean.setLec_content(rs.getString("lec_content"));
					bean.setLec_start(rs.getDate("lec_start"));
					bean.setLec_end(rs.getDate("lec_end"));
					bean.setLec_appl_start(rs.getDate("lec_appl_start"));
					bean.setLec_appl_end(rs.getDate("lec_appl_end"));
					bean.setLec_lecnum(rs.getInt("lec_lecnum"));
					bean.setLec_applnum(rs.getInt("lec_applnum"));
					bean.setLec_instructor(rs.getString("lec_instructor"));
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

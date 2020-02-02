package com.bit.home.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;
import com.bit.util.Paging;

public class EducurriculumDao {
	public ArrayList<EducurriculumDto> selectAll(Paging paging){
		int startNum=paging.getStartNum();
		int endNum=paging.getEndNum();
		System.out.println(startNum+"/"+endNum);
		
		/*String sql="SELECT X.RNUM, X.* FROM(SELECT ROWNUM AS RNUM, A.* FROM(SELECT * FROM RECR_BBS ORDER BY RECR_NO DESC) A WHERE ROWNUM<=?) X WHERE X.RNUM>=?";*/
		String sql="SELECT X.RNUM, X.* FROM(SELECT ROWNUM AS RNUM, A.* FROM(SELECT RECR_BBS.RECR_NO,RECR_BBS.LEC_CODE,LEC.LEC_NAME,LEC.LEC_APPL_START,LEC.LEC_APPL_END,LEC.LEC_APPLNUM,LEC.LEC_LECNUM FROM RECR_BBS INNER JOIN LEC ON RECR_BBS.LEC_CODE = LEC.LEC_CODE ORDER BY RECR_NO DESC) A WHERE ROWNUM<=?) X WHERE X.RNUM>=?";
		
		ArrayList<EducurriculumDto> list=null;
		list =new ArrayList<EducurriculumDto>();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, endNum);
			pstmt.setInt(2, startNum);
			rs=pstmt.executeQuery();
			while(rs.next()){
				EducurriculumDto bean=new EducurriculumDto();
				bean.setRecr_no(rs.getInt("RECR_NO"));
				bean.setLec_name(rs.getString("LEC_NAME"));
				bean.setLec_appl_start(rs.getDate("LEC_APPL_START"));
				bean.setLec_appl_end(rs.getDate("LEC_APPL_END"));
				bean.setLec_applnum(rs.getInt("LEC_APPLNUM"));
				bean.setLec_lecnum(rs.getInt("LEC_LECNUM"));
				list.add(bean);
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
		
		return list;
	}
	public int getAllCount(){
		String sql="SELECT COUNT(*) AS COUNT FROM RECR_BBS";
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt("COUNT");
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
		
		return count;
	}
}

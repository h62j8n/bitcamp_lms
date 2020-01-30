package com.bit.main.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class EducurriculumDao {
	public ArrayList<EducurriculumDto> selectAll(int page){
		int startNum=(page-1)*10+1;
		int endNum=page*10;
		System.out.println(startNum+"//"+endNum);
		
		String sql="SELECT X.RNUM, X.* FROM(SELECT ROWNUM AS RNUM, A.* FROM(SELECT * FROM RECR_BBS ORDER BY RECR_NO DESC) A WHERE ROWNUM<=?) X WHERE X.RNUM>=?";
		
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

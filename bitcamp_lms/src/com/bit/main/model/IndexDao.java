package com.bit.main.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class IndexDao {
	
	public ArrayList<IndexDto> selectAll(){
		String sql="SELECT B.LEC_NAME, A.RECR_DATE, A.RECR_NO FROM ";
		sql+="(SELECT RECR_NO, RECR_DATE, LEC_CODE FROM RECR_BBS) A, LEC B ";
		sql+="WHERE A.LEC_CODE=B.LEC_CODE ORDER BY A.RECR_NO DESC";
		
		ArrayList<IndexDto> list=new ArrayList<IndexDto>();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				IndexDto bean=new IndexDto();
				bean.setLec_name(rs.getString("lec_name"));
				bean.setRecr_date(rs.getDate("recr_date"));
				bean.setRecr_no(rs.getInt("recr_no"));
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

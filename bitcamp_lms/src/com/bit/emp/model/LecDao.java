package com.bit.emp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.util.BitOracle;

public class LecDao {
	public ArrayList<LecDto> selectAll(){
		String sql="SELECT * FROM LEC";
		
		ArrayList<LecDto> list=null;
		list =new ArrayList<LecDto>();
		Connection conn=BitOracle.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				LecDto bean=new LecDto();
				bean.setLec_applnum(rs.getInt("APPLNUM"));
				bean.setLec_lecnum(rs.getInt("LECNUM"));
				bean.setLec_start(rs.getDate("LEC_START"));
				bean.setLec_end(rs.getDate("LEC_END"));
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

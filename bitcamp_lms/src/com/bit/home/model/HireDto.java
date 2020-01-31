package com.bit.home.model;

import java.sql.Date;

public class HireDto {
	private int job_no;
	private String job_compname;
	private String job_loc;
	private int job_recrnum;
	private String job_emptype;
	private String job_enddate;
	
	public HireDto() {
	}
	public int getJob_no() {
		return job_no;
	}
	public void setJob_no(int job_no) {
		this.job_no = job_no;
	}
	public String getJob_compname() {
		return job_compname;
	}
	public void setJob_compname(String job_compname) {
		this.job_compname = job_compname;
	}
	public String getJob_loc() {
		return job_loc;
	}
	public void setJob_loc(String job_loc) {
		this.job_loc = job_loc;
	}
	public int getJob_recrnum() {
		return job_recrnum;
	}
	public void setJob_recrnum(int job_recrnum) {
		this.job_recrnum = job_recrnum;
	}
	public String getJob_emptype() {
		return job_emptype;
	}
	public void setJob_emptype(String job_emptype) {
		this.job_emptype = job_emptype;
	}
	public String getJob_enddate() {
		return job_enddate;
	}
	public void setJob_enddate(String job_enddate) {
		this.job_enddate = job_enddate;
	}
	
	
	
	
}

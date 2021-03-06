package com.bit.home.model;

import java.sql.Date;

public class HireDetailDto {
	private int job_no;
	private String job_compname;
	private String job_loc;
	private int job_recrnum;
	private String job_emptype;
	private String job_enddate;
	private String job_content;
	private int job_count;
	private Date job_date;
	
	public HireDetailDto() {
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
	public String getJob_content() {
		return job_content;
	}
	public void setJob_content(String job_content) {
		this.job_content = job_content;
	}
	public int getJob_count() {
		return job_count;
	}
	public void setJob_count(int job_count) {
		this.job_count = job_count;
	}
	public Date getJob_date() {
		return job_date;
	}
	public void setJob_date(Date job_date) {
		this.job_date = job_date;
	}
	
	
	
}

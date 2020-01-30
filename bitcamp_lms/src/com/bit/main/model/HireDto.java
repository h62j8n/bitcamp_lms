package com.bit.main.model;

import java.sql.Date;

public class HireDto {
	private int job_no;
	private int mb_no;
	private int emp_no;
	private String job_subject;
	private String job_content;
	private int job_count;
	private Date job_date;
	
	public HireDto() {
	}
	
	public int getJob_no() {
		return job_no;
	}
	public void setJob_no(int job_no) {
		this.job_no = job_no;
	}
	public int getMb_no() {
		return mb_no;
	}
	public void setMb_no(int mb_no) {
		this.mb_no = mb_no;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getJob_subject() {
		return job_subject;
	}
	public void setJob_subject(String job_subject) {
		this.job_subject = job_subject;
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

package com.bit.home.model;

import java.sql.Date;

public class NoticeDto {
	private int ntc_no;
	private int mb_no;
	private int emp_no;
	private String ntc_subject;
	private int ntc_count;
	private Date ntc_date;
	
	public NoticeDto() {
	}
	public int getNtc_no() {
		return ntc_no;
	}
	public void setNtc_no(int ntc_no) {
		this.ntc_no = ntc_no;
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
	public String getNtc_subject() {
		return ntc_subject;
	}
	public void setNtc_subject(String ntc_subject) {
		this.ntc_subject = ntc_subject;
	}
	public int getNtc_count() {
		return ntc_count;
	}
	public void setNtc_count(int ntc_count) {
		this.ntc_count = ntc_count;
	}
	public Date getNtc_date() {
		return ntc_date;
	}
	public void setNtc_date(Date ntc_date) {
		this.ntc_date = ntc_date;
	}
}

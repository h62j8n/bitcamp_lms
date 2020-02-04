package com.bit.lms.model;

import java.sql.Date;

public class TeacherNoticeDetailDto {
	private int cls_no;
	private String cls_subject;
	private String cls_content;
	private Date cls_date;
	private int cls_count;
	
	public TeacherNoticeDetailDto() {
	}
	public int getCls_no() {
		return cls_no;
	}
	public void setCls_no(int cls_no) {
		this.cls_no = cls_no;
	}
	public String getCls_subject() {
		return cls_subject;
	}
	public void setCls_subject(String cls_subject) {
		this.cls_subject = cls_subject;
	}
	public String getCls_content() {
		return cls_content;
	}
	public void setCls_content(String cls_content) {
		this.cls_content = cls_content;
	}
	public Date getCls_date() {
		return cls_date;
	}
	public void setCls_date(Date cls_date) {
		this.cls_date = cls_date;
	}
	public int getCls_count() {
		return cls_count;
	}
	public void setCls_count(int cls_count) {
		this.cls_count = cls_count;
	}
	
}

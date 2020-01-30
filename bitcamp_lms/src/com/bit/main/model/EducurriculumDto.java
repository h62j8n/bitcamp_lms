package com.bit.main.model;

import java.sql.Date;

public class EducurriculumDto {
	private int recr_no;
	private int mb_no;
	private int emp_no;
	private String recr_subject;
	private String recr_content;
	private int recr_count;
	private Date recr_date;
	
	public EducurriculumDto() {
	}

	public int getRecr_no() {
		return recr_no;
	}

	public void setRecr_no(int recr_no) {
		this.recr_no = recr_no;
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

	public String getRecr_subject() {
		return recr_subject;
	}

	public void setRecr_subject(String recr_subject) {
		this.recr_subject = recr_subject;
	}

	public String getRecr_content() {
		return recr_content;
	}

	public void setRecr_content(String recr_content) {
		this.recr_content = recr_content;
	}

	public int getRecr_count() {
		return recr_count;
	}

	public void setRecr_count(int recr_count) {
		this.recr_count = recr_count;
	}

	public Date getRecr_date() {
		return recr_date;
	}

	public void setRecr_date(Date recr_date) {
		this.recr_date = recr_date;
	}
}

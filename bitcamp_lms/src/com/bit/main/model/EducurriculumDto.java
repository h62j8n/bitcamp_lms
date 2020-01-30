package com.bit.main.model;

import java.sql.Date;

public class EducurriculumDto {
	private int recr_no;
	private int mb_no;
	private int emp_no;
	private int recr_count;
	private Date recr_date;
	private String lec_code;
	
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

	public String getLec_code() {
		return lec_code;
	}

	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	
	
}

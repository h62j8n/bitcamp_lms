package com.bit.home.model;

import java.sql.Date;

public class EducurriculumDto {
	private int recr_no;
	private int mb_no;
	private int emp_no;
	private int recr_count;
	private Date recr_date;
	private String lec_code;
	private String lec_name;
	private Date lec_start;
	private Date lec_end;
	private Date lec_appl_start;
	private Date lec_appl_end;
	private int lec_lecnum;
	private int lec_applnum;
	
	public EducurriculumDto() {
	}

	public String getLec_name() {
		return lec_name;
	}

	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
	}
	
	public Date getLec_start() {
		return lec_start;
	}

	public void setLec_start(Date lec_start) {
		this.lec_start = lec_start;
	}

	public Date getLec_end() {
		return lec_end;
	}

	public void setLec_end(Date lec_end) {
		this.lec_end = lec_end;
	}
	
	public Date getLec_appl_start() {
		return lec_appl_start;
	}

	public void setLec_appl_start(Date lec_appl_start) {
		this.lec_appl_start = lec_appl_start;
	}

	public Date getLec_appl_end() {
		return lec_appl_end;
	}

	public void setLec_appl_end(Date lec_appl_end) {
		this.lec_appl_end = lec_appl_end;
	}

	public int getLec_lecnum() {
		return lec_lecnum;
	}

	public void setLec_lecnum(int lec_lecnum) {
		this.lec_lecnum = lec_lecnum;
	}

	public int getLec_applnum() {
		return lec_applnum;
	}

	public void setLec_applnum(int lec_applnum) {
		this.lec_applnum = lec_applnum;
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

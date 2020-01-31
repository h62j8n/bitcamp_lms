package com.bit.lms.model;

import java.sql.Date;

public class LecDto {
	private String lec_code;
	private String lec_name;
	private String lec_instructor;
	private String lec_content;
	private Date lec_appl_start;
	private Date lec_appl_end;
	private Date lec_start;
	private Date lec_end;
	private int lec_roomno;
	private int lec_lecnum;
	private int lec_applnum;
	
	public LecDto() {
	}
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public String getLec_name() {
		return lec_name;
	}
	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
	}
	public String getLec_instructor() {
		return lec_instructor;
	}
	public void setLec_instructor(String lec_instructor) {
		this.lec_instructor = lec_instructor;
	}
	public String getLec_content() {
		return lec_content;
	}
	public void setLec_content(String lec_content) {
		this.lec_content = lec_content;
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
	public int getLec_roomno() {
		return lec_roomno;
	}
	public void setLec_roomno(int lec_roomno) {
		this.lec_roomno = lec_roomno;
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
}

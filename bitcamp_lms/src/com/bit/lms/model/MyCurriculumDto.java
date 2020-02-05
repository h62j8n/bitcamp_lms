package com.bit.lms.model;

import java.sql.Date;

public class MyCurriculumDto {
	private String lec_name;
	private Date lec_start;
	private Date lec_end;
	private String lec_code;
	private int lec_roomno;
	private String lec_instructor;
	private int lec_applnum;
	private int lec_lecnum;
	private String lec_content;
	private int sta_code;
	
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
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public int getLec_roomno() {
		return lec_roomno;
	}
	public void setLec_roomno(int lec_roomno) {
		this.lec_roomno = lec_roomno;
	}
	public String getLec_instructor() {
		return lec_instructor;
	}
	public void setLec_instructor(String lec_instructor) {
		this.lec_instructor = lec_instructor;
	}
	public int getLec_applnum() {
		return lec_applnum;
	}
	public void setLec_applnum(int lec_applnum) {
		this.lec_applnum = lec_applnum;
	}
	public int getLec_lecnum() {
		return lec_lecnum;
	}
	public void setLec_lecnum(int lec_lecnum) {
		this.lec_lecnum = lec_lecnum;
	}
	public String getLec_content() {
		return lec_content;
	}
	public void setLec_content(String lec_content) {
		this.lec_content = lec_content;
	}
	public int getSta_code() {
		return sta_code;
	}
	public void setSta_code(int sta_code) {
		this.sta_code = sta_code;
	}
		
}

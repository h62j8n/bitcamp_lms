package com.bit.lms.model;

import java.sql.Date;

public class TeacherScoreDto {
	private int mb_no;
	private int score_java;
	private int score_fw;
	private int score_db;
	private Date score_jdate;
	private Date score_fdate;
	
	public TeacherScoreDto() {
	}
	public int getMb_no() {
		return mb_no;
	}
	public void setMb_no(int mb_no) {
		this.mb_no = mb_no;
	}
	public int getScore_java() {
		return score_java;
	}
	public void setScore_java(int score_java) {
		this.score_java = score_java;
	}
	public int getScore_fw() {
		return score_fw;
	}
	public void setScore_fw(int score_fw) {
		this.score_fw = score_fw;
	}
	public int getScore_db() {
		return score_db;
	}
	public void setScore_db(int score_db) {
		this.score_db = score_db;
	}
	public Date getScore_jdate() {
		return score_jdate;
	}
	public void setScore_jdate(Date score_jdate) {
		this.score_jdate = score_jdate;
	}
	public Date getScore_fdate() {
		return score_fdate;
	}
	public void setScore_fdate(Date score_fdate) {
		this.score_fdate = score_fdate;
	}
	public Date getScore_ddate() {
		return score_ddate;
	}
	public void setScore_ddate(Date score_ddate) {
		this.score_ddate = score_ddate;
	}
	private Date score_ddate;
	
	
}

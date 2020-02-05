package com.bit.lms.model;

import java.sql.Date;

public class MemberDto {
	private int cate_no;
	private int mb_no;
	private String mb_id;
	private String mb_name;
	private int mb_tel;
	
	public MemberDto() {
	}

	public int getMb_no() {
		return mb_no;
	}

	public void setMb_no(int mb_no) {
		this.mb_no = mb_no;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public String getMb_name() {
		return mb_name;
	}

	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}

	public int getMb_tel() {
		return mb_tel;
	}

	public void setMb_tel(int mb_tel) {
		this.mb_tel = mb_tel;
	}

	public int getCate_no() {
		return cate_no;
	}

	public void setCate_no(int cate_no) {
		this.cate_no = cate_no;
	}
	
}

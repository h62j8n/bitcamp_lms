package com.bit.lms.model;

public class FindPwDto {
	private String id;
	private int cnt_id;
	private int cnt_qa;
	
	public FindPwDto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCnt_id() {
		return cnt_id;
	}

	public void setCnt_id(int cnt_id) {
		this.cnt_id = cnt_id;
	}

	public int getCnt_qa() {
		return cnt_qa;
	}

	public void setCnt_qa(int cnt_qa) {
		this.cnt_qa = cnt_qa;
	}
	
}

package com.bit.lms.model;

public class Member3Dto {
	private String name;
	private String id;
	private String tel;
	private int staCode;
	private String lecCode;
	private int lecRoomNo;
	private String lecName;
	
	public Member3Dto() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLecCode() {
		return lecCode;
	}

	public void setLecCode(String lecCode) {
		this.lecCode = lecCode;
	}

	public int getLecRoomNo() {
		return lecRoomNo;
	}

	public void setLecRoomNo(int lecRoomNo) {
		this.lecRoomNo = lecRoomNo;
	}

	public String getLecName() {
		return lecName;
	}

	public void setLecName(String lecName) {
		this.lecName = lecName;
	}

	public int getStaCode() {
		return staCode;
	}

	public void setStaCode(int staCode) {
		this.staCode = staCode;
	}
	
}

package com.bit.main.model;

import java.sql.Date;

public class IndexDto {
	private String subject;
	private Date date;
	
	public IndexDto() {
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}

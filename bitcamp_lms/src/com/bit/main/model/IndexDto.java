package com.bit.main.model;

import java.sql.Date;

public class IndexDto {
	private String lec_name;
	private Date recr_date;
	
	public IndexDto() {
	}

	public String getLec_name() {
		return lec_name;
	}

	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
	}

	public Date getRecr_date() {
		return recr_date;
	}

	public void setRecr_date(Date recr_date) {
		this.recr_date = recr_date;
	}
	
}

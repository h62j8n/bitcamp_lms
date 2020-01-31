package com.bit.home.model;

import java.sql.Date;

public class FAQDto {
	private int faq_no;
	private String faq_subject;
	private Date faq_date;
	private int faq_count;
	
	public FAQDto() {
	}
	public int getFaq_no() {
		return faq_no;
	}
	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}
	public String getFaq_subject() {
		return faq_subject;
	}
	public void setFaq_subject(String faq_subject) {
		this.faq_subject = faq_subject;
	}
	public Date getFaq_date() {
		return faq_date;
	}
	public void setFaq_date(Date faq_date) {
		this.faq_date = faq_date;
	}
	public int getFaq_count() {
		return faq_count;
	}
	public void setFaq_count(int faq_count) {
		this.faq_count = faq_count;
	}
}

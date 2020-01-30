package com.bit.util;

public class Paging {
	private int page=1;
	private int totalCount;
	private int beginPage;
	private int endPage;
	private int displayRow=10;
	private int displayPage=10;
	boolean prev;
	boolean next;
	
	public void setTotalCount(int totalCount){
		this.totalCount=totalCount;
		paging();
	}
	private void paging(){
		beginPage=((page-1)/displayPage)*displayPage+1;
		endPage=beginPage+displayPage-1;
		
		int totalPage=totalCount/displayRow;
		
		if(totalCount%displayRow>0){
			totalPage++;
		}
		if(totalPage<page){
			page=totalPage;
		}
		if(totalPage<endPage){
			endPage=totalPage;
			next=false;
		}else{
			next=true;
		}
		prev=(beginPage==1)?false:true;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotalCount() {
		return totalCount;
	}
}

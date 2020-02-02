package com.bit.util;

public class Paging {
	private int page=1;
	private int totalCount;
	private int beginPage;
	private int endPage;
	private int displayRow=5;
	private int displayPage=5;
	private int startNum;
	private int endNum;
	private int totalPage;
	boolean prev;
	boolean next;
	
	
	public void setTotalCount(int totalCount){
		this.totalCount=totalCount;
		paging();
	}
	private void paging(){
		beginPage=((page-1)/displayPage)*displayPage+1;
		endPage=beginPage+displayPage-1;
		startNum=(page-1)*displayRow+1;
		endNum=page*displayRow;
		
		/*int totalPage=totalCount/displayRow;*/
		totalPage=(int)Math.ceil(totalCount/(double)displayRow);
		
		/*if(totalCount%displayRow>0){
			totalPage++;
		}
		if(totalPage<page){
			page=totalPage;
		}*/
		if(totalPage<endPage){
			endPage=totalPage;
			next=false;
		}else{
			next=true;
		}
		prev=(beginPage==1)?false:true;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
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

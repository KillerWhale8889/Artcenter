package com.artcenter.VO;

import com.artcenter.Util.Criteria;

public class pageVO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total;
	private Criteria cri;
	
	
	public pageVO (Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		this.endPage = (int) (Math.ceil(cri.getPageNum()/10.0)) * 10;
		// Math.ceil : 소수점 자리 올림 
		this.startPage = this.endPage-9;
		int realEnd = (int) (Math.ceil((total * 1.0)/cri.getAmount()));
		// 레코드가 1n, 2n, ~ 일 때 실제 마지막 페이지 구하는 방법 
		if (realEnd < this.endPage ) {this.endPage = realEnd;}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
				
	}
	
	
	public int getStartPage() {
		return startPage;
	}



	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}



	public int getEndPage() {
		return endPage;
	}



	public void setEndPage(int endPage) {
		this.endPage = endPage;
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



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public Criteria getCri() {
		return cri;
	}



	public void setCri(Criteria cri) {
		this.cri = cri;
	}





}

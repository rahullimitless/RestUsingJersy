package com.demo.rest.messanger.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "MessageFilterBean [year=" + year + ", start=" + start
				+ ", size=" + size + "]";
	}
	
	

}

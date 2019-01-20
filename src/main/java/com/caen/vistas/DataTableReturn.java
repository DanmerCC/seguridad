package com.caen.vistas;

import java.util.HashMap;

public class DataTableReturn<T> {

	int sEcho;
	int iTotalRecords;
	int iTotalDisplayRecords;
	HashMap<String,T> aadata;
	HashMap<String,T> todo;
	public DataTableReturn(HashMap<String, T> aadata,Integer sEcho) {
		HashMap<String, Integer> basic= new HashMap<String,Integer>();
		basic.put("sEcho",sEcho);
		this.aadata = aadata;
	}
	public int getsEcho() {
		return sEcho;
	}
	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public HashMap<String, T> getAadata() {
		return aadata;
	}
	public void setAadata(HashMap<String, T> aadata) {
		this.aadata = aadata;
	}
	
}

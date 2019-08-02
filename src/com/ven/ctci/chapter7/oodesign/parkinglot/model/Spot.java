package com.ven.ctci.chapter7.oodesign.parkinglot.model;

public class Spot {
	private int id;
	private boolean available = true;
	public Spot(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAvailable() {
		return available;
	}
	public void occupy() {
		this.available = false;
	}
	
	public void release() {
		this.available = true;
	}
	

}

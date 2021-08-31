package com.example.easynotes.model;

import javax.persistence.Column;


public class SateliteTop_split {

	@Column(name = "distance")
	double distance;
	
	String[] message;

	public SateliteTop_split() {
		
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}
	

	
}

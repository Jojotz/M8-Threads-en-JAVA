package com.domain;

import java.util.ArrayList;
import java.util.List;

public class Thruster {
	
	private int maxPower;      		//Max power of a thruster
	private int currentPower; 		//Current power of a thruster
		
	public Thruster (int currentPower, int maxPower) {
		
		this.currentPower = currentPower;
		this.maxPower = maxPower;
	
	} 
		
	public int getMaxPower() {
		return maxPower;
	}
	
	public int getCurrentPower () {
		return currentPower;		
	}

	public void setCurrentPower(int currentPower) {
		this.currentPower = currentPower;
	}

}
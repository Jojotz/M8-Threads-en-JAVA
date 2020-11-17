package com.domain;

public class Thruster implements Runnable {
	
	private int maxPower;      		//Maximum power of a thruster
	private int currentPower; 		//Current power of a thruster
	private int targetPower;		//Total target power
	private Rocket rocket;			
	private int totCurrentPower;    //Total current power of all thrusters
	
	public Thruster (int currentPower, int maxPower, int targetPower, Rocket rocket) {
		
		this.currentPower = currentPower;
		this.maxPower = maxPower;
		this.targetPower = targetPower;
		this.rocket = rocket;
	} 

	public void run () {	
		
		totCurrentPower = getRocket().getTotalCurrentPower();
				
		if (getTargetPower() > totCurrentPower) {
			
			speedUp();
		
		} else if (getTargetPower() < totCurrentPower) {
				
			brake();	
		} 					
	}

	public synchronized void speedUp () {
			
		while (currentPower < maxPower && (getTargetPower() > getRocket().getTotalCurrentPower())) {
			
			currentPower++;				
			System.out.println(toString());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}				
		} 
	}
	
	public synchronized void brake () {
		
		while (currentPower > 0 && (getTargetPower() < getRocket().getTotalCurrentPower())) {
			
			currentPower--;
			System.out.println(toString());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		} 
	}	
	
	@Override
	public String toString () {
		
		StringBuilder output = new StringBuilder();
		output.append(getRocket().getCode());
		output.append(": ");
		output.append("P:");
		output.append(getRocket().getRocketCurrentPower() +"\n");
		
		if (getTargetPower() == getRocket().getTotalCurrentPower()) {
			
			output.append(" ---> El coet: " + getRocket().getCode() + " ha arribat a la potència objectiu." + "\n");
		
		} else if ((getTargetPower() > getRocket().getTotalCurrentPower()) && ( getTargetPower() > getRocket().getMaxTotPowerR()) && (getRocket().getTotalCurrentPower() ==  getRocket().getMaxTotPowerR())) {
			
			output.append(" ---> El coet: " + getRocket().getCode() + " ha arribat a la potència màxima, i no podrá assolir l'objectiu." + "\n");
		}
		
		return output.toString();
	}	
		
	public int getMaxPower() {
		return maxPower;
	}
	
	public int getCurrentPower () {
		return currentPower;		
	}

	public int getTargetPower() {
		return targetPower;
	}

	public void setTargetPower(int targetPower) {
		this.targetPower = targetPower;
	}
	
	public Rocket getRocket() {
		return rocket;
	}

	public void setRocket(Rocket rocket) {
		this.rocket = rocket;
	}
}
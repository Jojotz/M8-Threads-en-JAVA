package com.domain;

public class Thruster implements Runnable {
	
	private int maxPower;      			//Maximum power of a thruster
	private int currentPower; 			//Current power of a thruster
	private double targetSpeed;			//Total target power
	private Rocket rocket;			
	//private int totCurrentPower;    	//Total current power of all thrusters
	private double initialSpeed = 650;  //Declaro la Vo a 650 m/s
	
	public Thruster (int currentPower, int maxPower, float targetSpeed, Rocket rocket) {
		
		this.currentPower = currentPower;
		this.maxPower = maxPower;
		this.targetSpeed = targetSpeed;
		this.rocket = rocket;
	} 

	public void run () {	
				
		if (getTargetSpeed() > initialSpeed) {
			
			speedUp();		
		} 					
	}

	public synchronized void speedUp () {
			
		while (currentPower < maxPower && (getTargetSpeed() > getRocket().getCurrentSpeed())) {
			
			currentPower++;				
			System.out.println(toString());
			try {
				Thread.sleep(400);
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
		output.append(getRocket().getRocketCurrentPower());
		output.append( " V:");
		output.append(getRocket().getCurrentSpeed() + "m/s" +"\n");
		
		if (getTargetSpeed() <= getRocket().getCurrentSpeed()) {
			
			output.append(" ---> El coet: " + getRocket().getCode() + " ha arribat a la velocitat objectiu." + "\n");
		
		} else if ((getTargetSpeed() > getRocket().getCurrentSpeed()) && (getTargetSpeed() > getRocket().getMaxSpeedR()) && (getRocket().getCurrentSpeed() >=  getRocket().getMaxSpeedR())) {
			
			output.append(" ---> El coet: " + getRocket().getCode() + " ha arribat a la potència màxima, i no podrá assolir la velocitat l'objectiu." + "\n");
		}
		
		return output.toString();
	}	
		
	public int getMaxPower() {
		return maxPower;
	}
	
	public int getCurrentPower () {
		return currentPower;		
	}

	public double getTargetSpeed() {
		return targetSpeed;
	}

	public void setTargetSpeed(float targetSpeed) {
		this.targetSpeed = targetSpeed;
	}
	
	public Rocket getRocket() {
		return rocket;
	}

	public void setRocket(Rocket rocket) {
		this.rocket = rocket;
	}
}
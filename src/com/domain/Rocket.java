package com.domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String code;
	private List <Thruster> thrusters = new ArrayList <Thruster> ();
	private int maxTotPowerR;
	
	public Rocket(String code, List <Thruster> thrusters, int maxTotPowerR) throws Exception {
		
		if (code.equals(""))
			throw new Exception();
					
		this.code = code;
		this.thrusters = thrusters;
		this.maxTotPowerR = maxTotPowerR;
	}
	
	//Método que devuelve String de potencia máxima de cada propulsor en un cohete 		
	public String thrustMaxPowers () {
		
		String powerThrusters = "";
		
		for (int i=0; i<thrusters.size(); i++) {
			
			powerThrusters += thrusters.get(i).getMaxPower() + " - ";
		}
		return powerThrusters;
	}
	
	//Método que devuelve int de la potencia total actual de todos los propulsores de todos los cohetes. 
	public int getTotalCurrentPower () {
		
		int totalPower = 0;
		
			for (Thruster a: thrusters) {
			
				totalPower += a.getCurrentPower();
			}		
			return totalPower;
	}
	
	//Método que devuelve String la potencia total actual de un cohete con todos sus propulsores. 
	public String getRocketCurrentPower () {
		
		String individualPower = "";
		
		for (Thruster a: thrusters) {
		
			individualPower += "[" + a.getCurrentPower() + "/" + a.getMaxPower() + "]" ;
		}		
		return individualPower;
		
	}
	
	public int getMaxTotPowerR() {
		return maxTotPowerR;
	}

	public String getCode() {
		return code;
	}

	public List <Thruster> getThrusters() {
		return thrusters;
	}	
}
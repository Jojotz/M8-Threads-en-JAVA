package com.domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String code;
	private List <Thruster> thrusters = new ArrayList <Thruster> ();
		
	public Rocket(String code, List <Thruster> thrusters) throws Exception {
		
		if (code.equals(""))
			throw new Exception();
					
		this.code = code;
		this.thrusters = thrusters;
	}
			
	public String thrustMaxPowers () {
		
		String powerThrusters = "";
		
		for (int i=0; i<thrusters.size(); i++) {
			
			powerThrusters += thrusters.get(i).getMaxPower() + " - ";
		}
		return powerThrusters;
	}
		
	public String getCode() {
		return code;
	}

	public List <Thruster> getThrusters() {
		return thrusters;
	}
}
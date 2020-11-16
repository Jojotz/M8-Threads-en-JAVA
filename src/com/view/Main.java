/*
 * @author Joan Coll
 * @version M8 Threads en Java Fase 1 & Fase 2 16/11/2020
 */

package com.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.domain.Rocket;
import com.domain.Thruster;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		//Fase 1 & Fase 2   -> Pot actual, Pot max, Pot objetivo.
		Thruster thruster1 = new Thruster (0,10);
		Thruster thruster2 = new Thruster (0,30);
		Thruster thruster3 = new Thruster (0,80);
		
		List <Thruster> thrustersR1 = new ArrayList<Thruster>();
		
		thrustersR1.add(thruster1);
		thrustersR1.add(thruster2);
		thrustersR1.add(thruster3);
				
		Thruster thruster4 = new Thruster (0,30);
		Thruster thruster5 = new Thruster (0,40);
		Thruster thruster6 = new Thruster (0,50);
		Thruster thruster7 = new Thruster (0,50);
		Thruster thruster8 = new Thruster (0,30);
		Thruster thruster9 = new Thruster (0,10);
		
		List <Thruster> thrustersR2 = new ArrayList<Thruster>();
		
		thrustersR2.add(thruster4);
		thrustersR2.add(thruster5);
		thrustersR2.add(thruster6);
		thrustersR2.add(thruster7);
		thrustersR2.add(thruster8);
		thrustersR2.add(thruster9);
		
		//Creo rockets con su potencia total máxima
		Rocket rocket1 = new Rocket ("32WESSDS", thrustersR1);
		Rocket rocket2 = new Rocket ("LDSFJA32", thrustersR2);
		
		System.out.println ("Coet: " + rocket1.getCode() + " amb " + rocket1.getThrusters().size() + " propulsors, cadascun amb potència màxima de: " + rocket1.thrustMaxPowers());
		System.out.println ("Coet: " + rocket2.getCode() + " amb " + rocket2.getThrusters().size() + " propulsors, cadascun amb potència màxima de: " + rocket2.thrustMaxPowers());
	}
}
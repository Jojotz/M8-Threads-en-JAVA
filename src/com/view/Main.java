/*
 * @author Joan Coll
 * @version M8 Threads Fase 4 en Java 18/11/2020
 * Se pide a usuario una velocidad objetivo a asumir por cada cohete. Vo = 650 m/s. VmaxRocket1 = 1746 m/s VmaxRocket2 = 2099 m/s 
 */

package com.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.applications.MyControls;
import com.domain.Rocket;
import com.domain.Thruster;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Thruster thruster1 = new Thruster (0,10,0,null);
		Thruster thruster2 = new Thruster (0,30,0,null);
		Thruster thruster3 = new Thruster (0,80,0,null);
		
		List <Thruster> thrustersR1 = new ArrayList<Thruster>();
		
		thrustersR1.add(thruster1);
		thrustersR1.add(thruster2);
		thrustersR1.add(thruster3);
				
		Thruster thruster4 = new Thruster (0,30,0,null);
		Thruster thruster5 = new Thruster (0,40,0,null);
		Thruster thruster6 = new Thruster (0,50,0,null);
		Thruster thruster7 = new Thruster (0,50,0,null);
		Thruster thruster8 = new Thruster (0,30,0,null);
		Thruster thruster9 = new Thruster (0,10,0,null);
		
		List <Thruster> thrustersR2 = new ArrayList<Thruster>();
		
		thrustersR2.add(thruster4);
		thrustersR2.add(thruster5);
		thrustersR2.add(thruster6);
		thrustersR2.add(thruster7);
		thrustersR2.add(thruster8);
		thrustersR2.add(thruster9);
		
		//Creo rockets con su potencia total máxima y la velocidad inicial como velocidad actual, y la velocidad máxima
		Rocket rocket1 = new Rocket ("32WESSDS", thrustersR1, 120,650,1745.4451);
		Rocket rocket2 = new Rocket ("LDSFJA32", thrustersR2, 210,650,2099.13767);
		
		//Añado rockets a cada thruster
		thruster1.setRocket(rocket1);
		thruster2.setRocket(rocket1);
		thruster3.setRocket(rocket1);
		
		thruster4.setRocket(rocket2);
		thruster5.setRocket(rocket2);
		thruster6.setRocket(rocket2);
		thruster7.setRocket(rocket2);
		thruster8.setRocket(rocket2);
		thruster9.setRocket(rocket2);
		
		System.out.println ("Coet: " + rocket1.getCode() + " amb " + rocket1.getThrusters().size() + " propulsors, cadascun amb potència màxima de: " + rocket1.thrustMaxPowers());
		System.out.println ("Coet: " + rocket2.getCode() + " amb " + rocket2.getThrusters().size() + " propulsors, cadascun amb potència màxima de: " + rocket2.thrustMaxPowers() + "\n");
		
		System.out.println ("Ambdos coets es mouen a una velocitat incial de 650 m/s");
		
		//Fase 4		
		int choice = 0;
		Integer i = null;
		float targetSpeed = 0; 
				
		do {
			
			choice = 0;				
			
			try {
				
				choice = Integer.parseInt(JOptionPane.showInputDialog("Tria què vols fer: 1.- Introduir velocitat objectiu. / 2.- Tancar programa."));
				i = choice;
				choice = MyControls.wrongChoice(choice);
							
			} catch (NumberFormatException e) {
			        
				System.out.println("Error! Recorda: 1.- Introduir velocitat objectiu. / 2.- Tancar programa.");
			}
			
			switch  (choice) {			
						
				case 1:
									
					targetSpeed = Float.parseFloat(JOptionPane.showInputDialog("Introdueix la velocitat objectiu a assolir en m/s: "));
					targetSpeed = MyControls.rightSpeed(targetSpeed); //Controlamos que velocidad objetivo sea mayor que la inicial
				
					thruster1.setTargetSpeed(targetSpeed);
					thruster2.setTargetSpeed(targetSpeed);
					thruster3.setTargetSpeed(targetSpeed);
					
					thruster4.setTargetSpeed(targetSpeed);
					thruster5.setTargetSpeed(targetSpeed);
					thruster6.setTargetSpeed(targetSpeed);
					thruster7.setTargetSpeed(targetSpeed);
					thruster8.setTargetSpeed(targetSpeed);
					thruster9.setTargetSpeed(targetSpeed);
										
					Thread t1 = new Thread (thruster1);
					t1.start ();
					Thread t2 = new Thread (thruster2);
					t2.start ();
					Thread t3 = new Thread (thruster3);
					t3.start ();
					
					Thread t4 = new Thread (thruster4);
					t4.start ();
					Thread t5 = new Thread (thruster5);
					t5.start ();
					Thread t6 = new Thread (thruster6);
					t6.start ();
					Thread t7 = new Thread (thruster7);
					t7.start ();
					Thread t8 = new Thread (thruster8);
					t8.start ();
					Thread t9 = new Thread (thruster9);
					t9.start ();
					
					i = null;
					
				break; 
				
				case 2:									
				break; 	
							
				default: 						
			}	
			
		} while (i == null && choice != 2); 
	}
}
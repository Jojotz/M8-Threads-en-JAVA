package com.applications;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class MyControls extends InputMismatchException {
	
	public MyControls() {}
	
	public static int wrongChoice (int choice) {
		
		while (choice > 2 || choice < 1) {
			
			choice = Integer.parseInt(JOptionPane.showInputDialog("Número introduït incorrecte! Recorda: 1.- Introduir velocitat objectiu. / 2.- Tancar programa."));
		}		
		return choice;		
	}
	
	public static float rightSpeed (float targetSpeed ){
		
		while (targetSpeed <= 650 ) {
			
			targetSpeed = Integer.parseInt(JOptionPane.showInputDialog("Has introduït una velocitat més baixa de 650 m/s, torna-ho a probar"));
		}		
		return targetSpeed;		
	}
}
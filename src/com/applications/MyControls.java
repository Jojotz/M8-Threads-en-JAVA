package com.applications;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class MyControls extends InputMismatchException {
	
	public MyControls() {}
	
	public static int wrongChoice (int choice) {
		
		while (choice > 2 || choice < 1) {
			
			choice = Integer.parseInt(JOptionPane.showInputDialog("Número introduït incorrecte! Recorda: 1.- Introduir potència objectiu. / 2.- Tancar programa."));
		}		
		return choice;		
	}	
}
package view;

import javax.swing.JFrame;

import view.ApartmentGUI;

public class RunApartmentGUI {

	/**
	 * @param args
	 */
	// main method that makes a new apartment gui then a frame and then add the gui to the frame at set the visible of the frame to true.
	public static void main(String[] args) {
		ApartmentGUI apartmentGUI = new ApartmentGUI();
		JFrame s = new JFrame();
		s.add(apartmentGUI);
		s.setBounds(500, 500, 500, 500);
		s.setVisible(true);
		
	}

}

package launcher;

 


import java.awt.*; 
    

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
            		Student studentData = new Student(125925,"Adrover","Ramiro","ramadrover@gmail.com","https://github.com/RamiroAdrover","/images/photo.png");
                    SimplePresentationScreen frame = new SimplePresentationScreen(studentData);
                    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/tdp.png")));
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
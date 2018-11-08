package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import Model.Model;
import View.BuildGUI;


public class TBListener implements ActionListener {
	

	private Model model;
	private BuildGUI bg;
	
	public TBListener(Model m, BuildGUI b) {
		
		model = m;
		bg = b;
		
	} 
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.setDBF();
		model.setAF();
		model.setBF();
		model.setCBF();
		model.setLFBF();
		model.setRFBF();
		model.setSBF();
		model.setDBF();
		model.setRBF();
		model.setDBF();
		model.setTBF();
		
			switch (e.getActionCommand()) {
			case "Triangle":
				System.out.println("Triangle Button Selected");
				model.setTBT(); 
				break;
			case "Square":
				System.out.println("Square Button Selected");
				model.setSBT(); 
				break;
			case "RFlipper":
				System.out.println("RFlipper Button Selected");
				model.setRFBT(); 
				break;
			case "LFlipper":
				System.out.println("LFlipper Button Selected");
				model.setLFBT(); 
				break;
			case "Circle":
				System.out.println("Circle Button Selected");
				model.setCBT(); 
				break;
			case "Ball":
				System.out.println("Ball Button Selected");
				model.setBT(); 
				break;
			case "Absorber":
				System.out.println("Absorber Button Selected");
				model.setAT();
				break;
			case "Delete":
				System.out.println("Delete Button Selected");
				model.setDBT(); 
				break;
			case "Rotate":
				System.out.println("Rotate Button Selected");
				model.setRBT();
				break;
			
		
			}

		
		
	} 
	

}
	



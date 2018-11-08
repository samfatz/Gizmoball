package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Timer;


import Model.Model;
import View.BuildGUI;
import View.RunGUI;

public class SwitchToBuildListener implements ActionListener {

	private Timer timer;
	private Model model;
	private RunGUI rg;
	

	public SwitchToBuildListener(Model m, RunGUI r) {
	
		model = m;
		rg = r;
		timer = new Timer(50, this);
		
	} 
	


	@Override
	public final void actionPerformed(final ActionEvent e) {

		if (e.getSource() == timer) {
			model.moveBall();
		} else
			switch (e.getActionCommand()) {
			case "Build":
				model.stopBalls();
				model.setRunMode();
				new BuildGUI(model);
				rg.close();
				break;
			
		
			}
	
	}
	
	
}

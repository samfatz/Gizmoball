package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Timer;
import Model.Model;


public class RunListener implements ActionListener {

	private Timer timer;
	private Model model;

	public RunListener(Model m) {
		model = m;
		timer = new Timer(50, this);
	}
	
 
 
	@Override
	public final void actionPerformed(final ActionEvent e) {

		if (e.getSource() == timer) {
			model.moveBall();
		} else
			switch (e.getActionCommand()) {
			case "Start":
				timer.start();
				break;
			case "Stop":
				timer.stop();
				break;
				
			}
	
	}
}
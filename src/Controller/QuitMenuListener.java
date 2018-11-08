package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Model;


public class QuitMenuListener implements ActionListener {


	private Model model;

	public QuitMenuListener(Model m) {
		model = m;

	}



	@Override
	public final void actionPerformed(ActionEvent e) {

		model.quitGame();


	}
}
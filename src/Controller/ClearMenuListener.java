package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Model;


public class ClearMenuListener implements ActionListener {


	private Model model;

	public ClearMenuListener(Model m) {
		model = m;
	}



	@Override
	public final void actionPerformed(ActionEvent e) {

		model.clearBoard();


	}
}
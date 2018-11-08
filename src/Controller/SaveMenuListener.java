package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileSystemView;

import Model.Model;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class SaveMenuListener implements ActionListener {


	private Model model;

	public SaveMenuListener(Model m) {
		model = m;
	
	}



	@Override
	public final void actionPerformed(ActionEvent e) {

		try {

			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			int returnValue = jfc.showOpenDialog(null);
			// int returnValue = jfc.showSaveDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				model.saveGame(selectedFile.getPath());
				System.out.println(selectedFile.getAbsolutePath());
			}


		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}



}

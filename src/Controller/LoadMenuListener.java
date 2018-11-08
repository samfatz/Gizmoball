package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import javax.swing.filechooser.FileSystemView;

import Model.Model;


public class LoadMenuListener implements ActionListener {

	
	private Model model;
	private String path;
				
	public LoadMenuListener(Model m, String path) {
		model = m;
		this.path = path;
	}



	@Override
	public final void actionPerformed(ActionEvent e) {

		try {
			
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			int returnValue = jfc.showOpenDialog(null);
			// int returnValue = jfc.showSaveDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				model.clearBoard();
				File selectedFile = jfc.getSelectedFile();
				model.loadGame(selectedFile.getPath());
				System.out.println(selectedFile.getAbsolutePath());
			}

		
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}
}
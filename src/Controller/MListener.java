package Controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Model;
import View.BuildGUI;

public class MListener implements MouseListener {

	private BuildGUI gui;
	private Model model;

	public MListener(BuildGUI g, Model m) {
		gui = g;
		model = m;
		gui.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int l =20;
		int x=model.rounder((e.getX()-7));
		int y=model.rounder((e.getY()-102));
		
		System.out.println("listener");

		


		if(model.getDBT()==true) {

			String id = (x + "" + y );

			System.out.println(id);

			if (model.checkTaken(x, y)) { 

				model.removeLFlipper("LF"+id);
				model.removeRFlipper("RF"+id);
				model.removeSBumper("S"+id);
				model.removeCBumper("C"+id);
				model.removeTBumper(x, y);
				model.removeSqOccupied(x, y);
				model.removeAbsorber();
			
				

			}


		}



		if(model.getRBT()==true) {
			
			
			
			
						if ((model.checkTaken(x, y))) { 
						model.rotateTBumper(x, y);
						
						}
						
			
			 		}
		
		
		if(model.getTBT()==true) {
			

			if (!(model.checkTaken(x, y))) { 
				model.addTriangleBumper(x, y); 
				
			}


		}

		if(model.getSBT()==true) {
			


			if (!(model.checkTaken(x, y))) { 

				model.addSquareBumper(x, y+25);
				

			}

		}

		if(model.getLFBT()==true) {

			if (!(model.checkTaken(x, y)) && !(model.checkTaken(x, y+25)))  { 
		
				model.addLFlipper(x, y); 
				
			}

		}

		if(model.getRFBT()==true) {

			if (!(model.checkTaken(x, y)) && !(model.checkTaken(x, y+25))) { 

				model.addRFlipper(x, y); 
				
			}

		}

		if(model.getCBT()==true) {
			System.out.println("hey2");

			if (!(model.checkTaken(x, y))) { 

				model.addCircleBumper(x+12.5, y+12.5); 
				
				
			}

		}

		if(model.getBT()==true) {

			model.addBall(e.getX()-7, e.getY()-102); 
	
		

		}

		if(model.getA()==true) {

			model.addAbsorber(); 
			

		}

	
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

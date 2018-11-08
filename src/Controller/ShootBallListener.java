package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

import javax.swing.Timer;

import Model.Model;

public class ShootBallListener implements KeyListener {

	private final HashSet<Integer> pressed = new HashSet<Integer>();
	private Model model;
	private Timer t;
	private Timer t2;

	public ShootBallListener(Model m) {
		model = m;
		t = new Timer(150, new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(pressed.contains(KeyEvent.VK_E)) {
					model.flipRightFlipper();

				}
			
			}
		});
		
		t2 = new Timer(150, new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(!pressed.contains(KeyEvent.VK_E)) {
					model.unflipRightFlipper();

				}
			
			}
		});

		

	}

	public void keyTyped(KeyEvent e) {
		return;
	}

	public void keyPressed(KeyEvent e) {
		t2.stop();
		t.start();
		pressed.add(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_S) {
			model.shootBall();

		}
	}

	public void keyReleased(KeyEvent e) {
		t.stop();
		pressed.remove(e.getKeyCode());
		t2.start();
	}



}

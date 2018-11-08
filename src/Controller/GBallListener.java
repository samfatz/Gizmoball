package Controller;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import javax.swing.event.MouseInputListener;

public interface GBallListener extends ActionListener, WindowListener, KeyListener, MouseInputListener {

	public void setMouseListener (MouseInputListener ml);
	public void setKeyBoardListener(KeyListener kl);

	
	
}

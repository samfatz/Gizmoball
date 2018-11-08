package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controller.QuitMenuListener;
//import Controller.ShootBallListener;
import Controller.RunListener;
import Controller.ShootBallListener;
import Controller.SwitchToBuildListener;
import Model.Model;

public class RunGUI extends JFrame {

	private Board board;
	private JMenu fileMenu;
	private JMenuBar menuBar;
	private JMenuItem Quit;
	private Model m;
	private ActionListener listener;
	private ShootBallListener listener1;
	private SwitchToBuildListener listener2;
	private QuitMenuListener quitMenuListener;

	public RunGUI(Model m) {

		super("Gizmoball");

		this.m = m;

		board = new Board(600, 600, m);
		fileMenu = new JMenu("Menu");
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		Quit = new JMenuItem("Quit");
        fileMenu.add(Quit);
		listener = new RunListener(m);
		listener1 = new ShootBallListener(m);
		listener2 = new SwitchToBuildListener(m, this);
		quitMenuListener = new QuitMenuListener(m);

		setSize(517, 597);
		//setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cPane = getContentPane();
		
		Font gf = new Font("Arial", Font.BOLD, 12);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());

		Quit.addActionListener(quitMenuListener);
		
		JButton button1 = new JButton("Start");
		button1.addActionListener(listener);
		button1.setFont(gf);
		button1.setFocusable(false);
		buttons.add(button1);

		JButton button2 = new JButton("Build");
		button2.addActionListener(listener2);
		button2.setFont(gf);
		button2.setFocusable(false);
		buttons.add(button2);
		
		JButton button3 = new JButton("Stop");
		button3.addActionListener(listener);
		button3.setFont(gf);
		button3.setFocusable(false);
		buttons.add(button3);
		
		
		
		cPane.add(buttons, BorderLayout.NORTH);
		cPane.add(board, BorderLayout.CENTER);
		
		
		this.addKeyListener(listener1);
		
		setVisible(true);
	}
	
	public void close(){
		setVisible(false);
	}

}













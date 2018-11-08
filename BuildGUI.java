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
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Controller.MListener;
//import Controller.ShootBallListener;
import Controller.RunListener;
import Controller.ShootBallListener;
import Controller.SwitchToBuildListener;
import Controller.SwitchToRunListener;
import Model.Model;

public class BuildGUI extends JFrame {

	private Board board;
	private Grid grid;
	private JMenu fileMenu;
	private JMenuBar menuBar;
	private Model m;
	private ActionListener listener;
	private ShootBallListener listener1;
	private SwitchToRunListener listener2;
	private TBListener listener3; 
	private MListener getCoords;
	private JLayeredPane lpane = new JLayeredPane();
	

	public BuildGUI(Model m) {

		super("Gizmoball");

		this.m = m;
		grid = new Grid(20,20);
		board = new Board(600, 600, m);
		fileMenu = new JMenu("Menu");
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		listener = new RunListener(m);
		listener1 = new ShootBallListener(m);
		listener2 = new SwitchToRunListener(m, this);
		listener3 = new TBListener(m, this);
		getCoords = new MListener(this, m);
		lpane.setBounds(0, 0, 500, 500);
		board.setOpaque(true);
		board.setBounds(0, 0, 500, 500);
		lpane.add(board, new Integer(1), 0);
	    lpane.add(grid, new Integer(0), 0);
	    
		

		setSize(517, 597);
		//setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cPane = getContentPane();
		
		Font gf = new Font("Arial", Font.BOLD, 12);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());

		JButton button2 = new JButton("Run");
		button2.addActionListener(listener2);
		button2.setFont(gf);
		button2.setFocusable(false);
		buttons.add(button2);
		
		JButton button3 = new JButton("Square");
		//button3.addActionListener(listener2);
		button3.setFont(gf);
		button3.setFocusable(false);
		buttons.add(button3);
		
		JButton button4 = new JButton("Triangle");
		button4.addActionListener(listener3);
		button4.setFont(gf);
		button4.setFocusable(false);
		buttons.add(button4);
		
		JButton button5 = new JButton("Circle");
		//button3.addActionListener(listener2);
		button5.setFont(gf);
		button5.setFocusable(false);
		buttons.add(button5);
		
		JButton button6 = new JButton("RFlipper");
		//button3.addActionListener(listener2);
		button6.setFont(gf);
		button6.setFocusable(false);
		buttons.add(button6);
		
		JButton button7 = new JButton("LFlipper");
		//button3.addActionListener(listener2);
		button7.setFont(gf);
		button7.setFocusable(false);
		buttons.add(button7);
		
		
		JButton button8 = new JButton("Connect");
		//button3.addActionListener(listener2);
		button8.setFont(gf);
		button8.setFocusable(false);
		buttons.add(button8);
		
		JButton button9 = new JButton("Load");
		button9.addActionListener(listener);
		button9.setFont(gf);
		buttons.add(button9);
		
		
		JButton button11 = new JButton("Rotate");
		//button3.addActionListener(listener2);
		button11.setFont(gf);
		button11.setFocusable(false);
		buttons.add(button11);
	
		
		JButton button10 = new JButton("Delete");
		//button3.addActionListener(listener2);
		button10.setFont(gf);
		button10.setFocusable(false);
		buttons.add(button6);
		
		JButton button12 = new JButton("Save");
		//button3.addActionListener(listener2);
		button12.setFont(gf);
		button12.setFocusable(false);
		buttons.add(button12);
		
		cPane.add(buttons, BorderLayout.NORTH);
		cPane.add(lpane, BorderLayout.CENTER);
		
		
		this.addKeyListener(listener1);
		this.addMouseListener(getCoords);
		
		setVisible(true);
	}
	
	public void close(){
		setVisible(false);
	}
	
	

}













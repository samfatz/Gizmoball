package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Grid extends JPanel {
	

	JButton[][] grid; //names the grid of buttons
	 
	public Grid(int width, int length){ //constructor with 2 parameters
			this.setSize(500,500);
		
	        this.setLayout(new GridLayout(width,length)); //set layout of frame
	        grid=new JButton[width][length]; //allocate the size of grid
	        for(int y=0; y<length; y++){ 
	                for(int x=0; x<width; x++){
	                		
	                        grid[x][y]=new JButton("("+x+","+y+")");   
	                      
	                        grid[x][y].setVisible(false);
	                        this.add(grid[x][y]); //adds button to grid
	                     
	                }
	        }
	}
}

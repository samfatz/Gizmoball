package Model;

import physics.*;
import java.awt.geom.AffineTransform;
import java.awt.Color;

/**
 * Created by xnb15172 on 12/02/2018.
 */

public class Flipper

{
	private int xpos;
	private int ypos;
	private int width;
	private int degree;
	public Flipper(int x, int y, int w, int d) {
		xpos = x;
		ypos = y;
		width = w;
		degree = d;
	}

	public int getXpos() {
		return xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setXpos(int newX) {
		xpos = newX; 
	}

	public void setYpos(int y) {
		y = ypos;
	}

	public int getWidth() {
		return width;
	}

	public void flipRight(){
		degree = 0;


	}

	public void flipLeft(){
		degree = 180;


	}


	public void unFlipRight(){
		degree = -90;
	}

	public void unFlipLeft(){
		degree = -90;
	}


	public int getDegree(){
		return degree;

	}

}

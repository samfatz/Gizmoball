 package Model;

import java.awt.Color;

import physics.LineSegment;


public class Absorber {

	private double xpos;
	private double ypos;
	private double width;
	private Color colour;
	private LineSegment ls;
	private String ID;

	public Absorber(String ID, double x, double y, double dunno, double w) {
		xpos = x;
		ypos = y;
		width = w;
		colour = Color.GREEN;
		ls = new LineSegment(x, y, x + w, y);
		this.ID = ID;
	}

	public LineSegment getLineSeg() {
		return ls;
	}

	public double getX() {
		return xpos;
	}

	public double getY() {
		return ypos;
	}

	public double getWidth() {
		return width;
	}

	public Color getColour(){
		return colour;
	}
	
	public String getID() {
		// TODO Auto-generated method stub
		return ID;
	}
}

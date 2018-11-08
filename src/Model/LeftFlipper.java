package Model;

import physics.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.awt.Color;



public class LeftFlipper

{
	private double xpos;
	private double ypos;
	private int width;
	private Color colour;
	private int degree;
	private ArrayList<Circle> circles;
	private ArrayList<LineSegment> lines;
	private String ID;
	
	public LeftFlipper(String ID, double x, double y) {
		xpos = x;
		ypos = y;
		colour = Color.decode("#EC4590");
		width = 50;
		degree = -90;
		lines = new ArrayList<>();
		this.ID = ID;
		circles = new ArrayList<>();
		circles.add(new Circle(new Vect((x+5), (y+5)), 5));
	 	circles.add(new Circle(new Vect((x+5), (y+width)-5), 5));


		lines.add(new LineSegment(circles.get(0).getCenter().getX()+5, circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX()+5, circles.get(1).getCenter().getY()));
		lines.add(new LineSegment(circles.get(0).getCenter().getX()-5, circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX()-5, circles.get(1).getCenter().getY()));
	}

	public double getXpos() {
		return xpos;
	}
	public ArrayList<LineSegment> getLines(){
		return lines;
	}
	
	public ArrayList<Circle> getCircles(){
		return circles;
	}


	public double getYpos() {
		return ypos;
	}

	public void setXpos(double newX) {
		xpos = newX;
	}

	public void setYpos(double y) {
		y = ypos;
	}

	public int getWidth() {
		return width;
	}

	public void flip(){
		degree = 0;
		circles.remove(1);
		circles.add(new Circle(new Vect(circles.get(0).getCenter().getX()+40, circles.get(0).getCenter().getY()), 5));
		lines.removeAll(lines);
		lines.add(new LineSegment(circles.get(0).getCenter().getX()-5, circles.get(0).getCenter().getY()-5, circles.get(1).getCenter().getX()-5, circles.get(1).getCenter().getY()-5));
		lines.add(new LineSegment(circles.get(0).getCenter().getX()+5, circles.get(0).getCenter().getY()+5, circles.get(1).getCenter().getX()+5, circles.get(1).getCenter().getY()+5));
	

	}


	public void unFlip(){
		degree = -90;
		circles.remove(1);
		circles.add(new Circle(new Vect(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY()+40), 5));
		lines.removeAll(lines);
		lines.add(new LineSegment(circles.get(0).getCenter().getX()+5, circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX()+5, circles.get(1).getCenter().getY()));
		lines.add(new LineSegment(circles.get(0).getCenter().getX()-5, circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX()-5, circles.get(1).getCenter().getY()));
	}



	public int getDegree(){
		return degree;

	}
	
	public Color getColour(){
		return colour;
	}
	
	public String getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
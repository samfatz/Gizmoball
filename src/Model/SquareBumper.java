package Model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

public class SquareBumper {

	
	
	private double xpos;
	private double ypos;
	private Color colour;
	private LineSegment ls;
	private double w;
	private ArrayList<Circle> circles;
	private ArrayList<LineSegment> lines;
	private double radius;
	private Circle circle;
	private String ID;

 	
public SquareBumper(String ID, double x, double y){
	xpos = x;
	ypos = y;
	w = 25;
	radius = 0;
	circles = new ArrayList<>();
	lines = new ArrayList<>();
	this.ID = ID;
	colour = Color.decode("#FF938F");
	circles.add(new Circle(new Vect(((x)), ((y))), radius));
	circles.add(new Circle(new Vect(((x+w)), ((y))), radius));
	circles.add(new Circle(new Vect(((x+w)), ((y-w))), radius));
	circles.add(new Circle(new Vect(((x)), ((y-w))), radius));
	lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY()));
	lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(3).getCenter().getX(), circles.get(3).getCenter().getY()));
	lines.add(new LineSegment(circles.get(3).getCenter().getX(), circles.get(3).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));
	lines.add(new LineSegment(circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY(), circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY()));

}	

public double getWidth(){
	return w;
}

public double getRadius(){
	return radius;
}

public ArrayList<Circle> getCircles(){
	return circles;
}

public ArrayList<LineSegment> getLines(){
	return lines;
}

public LineSegment getLine(){
	return ls;
}

public double getExactX(){
	return xpos;
}

public double getExactY(){
	return ypos;
}

public Color getColour(){
	return colour;
}

public String getID() {
	// TODO Auto-generated method stub
	return ID;
}

}
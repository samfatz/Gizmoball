package Model;

import java.awt.Color;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

public class CircleBumper {

	
	private double radius;
	private double xpos;
	private double ypos;
	private Color colour;
	private Circle circle;
	private String ID;
	

	
	
public CircleBumper(String id, double x, double y){
	xpos = x;
	ypos = y;
	colour = Color.decode("#5CB8CC");
	radius = 12.5;
	circle = new Circle(new Vect(x, y), radius);
	this.ID = id;
}
 


public double getRadius(){
	return radius;
}

public Circle getCircle(){
	return circle;
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
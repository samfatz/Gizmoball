package Model;

import java.awt.Color;

import physics.Circle;
import physics.Vect;

public class Ball {

	private Vect velocity;
	private double radius;
	private double xpos;
	private double ypos;
	private Color colour;
	private String ID;
	private boolean stopped;
	
	
public Ball(String ID, double x, double y, double xv, double yv){
	xpos = x;
	ypos = y;
	colour = Color.YELLOW;
	velocity = new Vect(xv, yv);
	radius = 6.25;
	stopped = false;
	this.ID = ID;
}

public Vect getVelo(){
	return velocity;
}

public void setVelo(Vect v){
	velocity = v;
}

public double getRadius(){
	return radius;
}

public Circle getCircle(){
	return new Circle(xpos, ypos, radius);
}

public double getExactX(){
	return xpos;
}

public double getExactY(){
	return ypos;
}

public void setExactX(double x){
	xpos = x;
}

public void setExactY(double y){
	ypos = y;
}

public void stop(){
	stopped = true;
}

public void start(){
	stopped = false;
}

public boolean stopped(){
	return stopped;
}

public Color getColour(){
	return colour;
}

public String getID() {
	// TODO Auto-generated method stub
	return ID;
}

}
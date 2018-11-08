package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Scanner;
import java.util.StringTokenizer;



import Model.CollisionDetails;
import Model.VerticalLine;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

public class Model extends Observable {


	private Walls walls;
	private ArrayList<Ball> ball;
	private ArrayList<CircleBumper> CBumper;
	private ArrayList<TriangleBumper> Triangle;
	private ArrayList<SquareBumper> SBumper;
	private ArrayList<RightFlipper> rFlipper;
	private ArrayList<LeftFlipper> lFlipper;
	private ArrayList<Absorber> absorb;
	private final double GRAVITY = 875;
	private final double MU = 0.025;
	private final double MU2 = 0.025;
	private boolean runMode;
	private boolean triangleBumper;
	private boolean squareBumper;
	private boolean rFlipperBumper;
	private boolean lFlipperBumper;
	private boolean CircleBumper;
	private boolean absorber;
	private boolean deleteBumper;
	private boolean b;
	private boolean rotateBumper;
	private boolean[][] occupiedSq;
	private String gizmoID;
	Iterator <TriangleBumper> tItr;
	Iterator <SquareBumper> sqItr;
	Iterator <RightFlipper> rfItr;
	

	public Model() {

		walls = new Walls(0, 0, 500, 500);
		absorb = new ArrayList<>();
		rFlipper = new ArrayList<>();
		lFlipper = new ArrayList<>();
		CBumper = new ArrayList<>();
		SBumper = new ArrayList<>();
		Triangle = new ArrayList<>();
		ball = new ArrayList<>();
		runMode = false;
		triangleBumper =false;
		squareBumper=false;
		rFlipperBumper=false;
		lFlipperBumper=false;
		CircleBumper = false;
		deleteBumper = false;
		rotateBumper = false;
		b = false;
		absorber = false;
		occupiedSq = new boolean[20][20];
		gizmoID=null;
		tItr = Triangle.iterator();
		sqItr = SBumper.iterator();
		rfItr = rFlipper.iterator();

	}

	public boolean getOccupiedSq(int x, int y) {
		return occupiedSq[x/25][y/25];
	}

	public void sqOccupied(int x, int y) {
		
		
		occupiedSq[x/25][y/25] = true;
		
	}

	public boolean checkTaken(double x, double y){
		
	
		return occupiedSq[(int)x/25][(int)y/25];
		
	}
	
	public void removeSqOccupied(int x, int y)
	{
		occupiedSq[x/25][y/25] = false;
	}
	
	public ArrayList<Ball> getBall() {
		return ball;
	}

	public boolean getRunMode() {
		return runMode;
	}

	public void setRunMode() {

	
		runMode = false;

	}

	public void setRunModeT() {

		runMode = true;
	}
	
	public void setBT(){
		b = true;
	}
	
	public void setBF(){
		b = false;
	}
	
	public boolean getBT(){
		return b;
	}
	
	

	public void setTBT() {

		triangleBumper = true;
	}

	public void setTBF() {

		triangleBumper = false;
	}

	public boolean getTBT() {

		return triangleBumper;
	}

	public void setSBT() {

		squareBumper = true;
	}

	public void setSBF() {

		squareBumper = false;
	}

	public boolean getSBT() {

		return squareBumper;
	}

	public void setRFBT() {

		rFlipperBumper = true;
	}

	public void setRFBF() {

		rFlipperBumper = false;
	}

	public boolean getRFBT() {

		return rFlipperBumper;
	}

	public void setLFBT() {

		lFlipperBumper = true;
	}

	public void setLFBF() {

		lFlipperBumper = false;
	}

	public boolean getLFBT() {

		return lFlipperBumper;
	}

	public void setCBT() {

		CircleBumper = true;
	}

	public void setCBF() {

		CircleBumper = false;
	}

	public boolean getCBT() {

		return CircleBumper;
	}
	
	public void setAT(){
		absorber = true;
	}
	
	public void setAF(){
		absorber = false;
	}
	
	public boolean getA(){
		return absorber;
	}
	
	public boolean getDBT() {

		return deleteBumper;
	}

	public void setDBT() {

		deleteBumper = true;
	}

	public void setDBF() {

		deleteBumper = false;
	}

	public boolean getDBF() {

		return deleteBumper;
	}

	public boolean getRBT() {

		return rotateBumper;
	}

	public void setRBT() {

		rotateBumper = true;
	}

	public void setRBF() {

		rotateBumper = false;
	}

	public boolean getRBF() {

		return rotateBumper;
	}



	public ArrayList<CircleBumper> getCBumper() {
		return CBumper;
	}

	public ArrayList<Absorber> getAbsorb() {
		return absorb;
	}

	public ArrayList<SquareBumper> getSBumper() {
		return SBumper;
	}

	public ArrayList<TriangleBumper> getTB() {
		return Triangle;
	}

	public ArrayList<LeftFlipper> getLF() {
		return lFlipper;
	}

	public ArrayList<RightFlipper> getRF() {
		return rFlipper;
	}

	private Ball movelBallForTime(Ball ball, double time) {

		double newX = 0.0;
		double newY = 0.0;
		double xVel = ball.getVelo().x();
		double yVel = ball.getVelo().y();
		newX = ball.getExactX() + (xVel * time);
		newY = ball.getExactY() + (yVel * time);
		ball.setExactX(newX);
		ball.setExactY(newY);
		return ball;
	}

	public void flipRightFlipper(){
		for (RightFlipper rf: rFlipper) {

			rf.flip();
			this.setChanged();
			this.notifyObservers();

		}
	}

	public void unflipRightFlipper(){
		for (RightFlipper rf : rFlipper) {

			rf.unFlip();
			this.setChanged();
			this.notifyObservers();

		}
	}

	public void flipLeftFlipper(){
		for (LeftFlipper lf : lFlipper) {

			lf.flip();
			this.setChanged();
			this.notifyObservers();

		}
	}

	public void unflipLeftFlipper(){
		for (LeftFlipper lf : lFlipper) {

			lf.unFlip();
			this.setChanged();
			this.notifyObservers();

		}
	}



	public void moveBall() {

		double moveTime = 0.03; // 0.05 = 20 times per second as per Gizmoball

		for (Ball b: ball) {
		if (b != null && !b.stopped()) {

			CollisionDetails cd = timeUntilCollision(b);
			double tuc = cd.getTuc();
			if (tuc > moveTime) {
				// No collision ...
				b = movelBallForTime(b, moveTime);
				applyGravity(moveTime, b);
					applyFriction(moveTime,b);
			} else {
				// We've got a collision in tuc
				b = movelBallForTime(b, tuc);
				// Post collision velocity ...

				b.setVelo(cd.getVelo());
				// ball.setExactX(550);
				applyGravity(tuc, b);
						applyFriction(tuc, b);

			}
		}

			// Notify observers ... redraw updated view
			this.setChanged();
			this.notifyObservers();
		}
		
	}
	
	public void stopBalls(){
		for(Ball b : ball){
			b.stop();
		}
	}
	
	public void startBalls(){
			for(Ball b : ball){
				b.start();
			}
		}
	

	private CollisionDetails timeUntilCollision(Ball b) {
		// Find Time Until Collision and also, if there is a collision, the new
		// speed vector.
		// Create a physics.Circle from Ball
		Circle ballCircle = b.getCircle();
		Vect ballVelocity = b.getVelo();
		Vect newVelo = new Vect(0, 0);

		// Now find shortest time to hit a vertical line or a wall line
		double shortestTime = Double.MAX_VALUE;
		double time = 0.0;


		//here
		for (Absorber absorber : absorb) {
			LineSegment ls = absorber.getLineSeg();
			time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo =  new Vect(0, 0);
				//ball.setExactX(550);
				b.stopped();
		
			}
		}

		// Time to collide with 4 walls
		ArrayList<LineSegment> lss = walls.getLineSegments();
		for (LineSegment line : lss) {
			time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(line, b.getVelo(), 1.0);
			}
		}

		for (CircleBumper bump : CBumper) {
			time = Geometry.timeUntilCircleCollision(bump.getCircle(), ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectCircle(bump.getCircle().getCenter(), b.getCircle().getCenter(),
						b.getVelo(), 1.0);
			}
		}
		
		for (Ball balls : ball) {
			time = Geometry.timeUntilCircleCollision(balls.getCircle(), ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectCircle(balls.getCircle().getCenter(), b.getCircle().getCenter(),
						b.getVelo(), 1.0);
			}
		}





		for (SquareBumper Sbump : SBumper) {
			for (int i = 0; i < Sbump.getCircles().size(); i++) {
				time = Geometry.timeUntilCircleCollision(Sbump.getCircles().get(i), ballCircle, ballVelocity);
				if (time < shortestTime) {
					shortestTime = time;
					newVelo = Geometry.reflectCircle(Sbump.getCircles().get(i).getCenter(),
							b.getCircle().getCenter(), b.getVelo(), 1.0);
				}
				
			}
			}

			for (SquareBumper Sbump1 : SBumper) {
				for (int i = 0; i < Sbump1.getLines().size(); i++) {
					time = Geometry.timeUntilWallCollision(Sbump1.getLines().get(i), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectWall(Sbump1.getLines().get(i), b.getVelo(), 1.0);

					}
				}
			}

			for (TriangleBumper Tbump : Triangle) {
				for (int i = 0; i < Tbump.getCircles().size(); i++) {
					time = Geometry.timeUntilCircleCollision(Tbump.getCircles().get(i), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(Tbump.getCircles().get(i).getCenter(),
								b.getCircle().getCenter(), b.getVelo(), 1.0);
					}
				}
			} 

			for (TriangleBumper Tbump1 : Triangle) {
				for (int i = 0; i < Tbump1.getLines().size(); i++) {
					time = Geometry.timeUntilWallCollision(Tbump1.getLines().get(i), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectWall(Tbump1.getLines().get(i), b.getVelo(), 1.0);

					}
				}

			}
			for (RightFlipper rFlip : rFlipper) {
				for (int i = 0; i < rFlip.getLines().size(); i++) {
					time = Geometry.timeUntilWallCollision(rFlip.getLines().get(i), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectWall(rFlip.getLines().get(i), b.getVelo(), 1.0);

					}
				}

			}
			
			for (RightFlipper rFlip : rFlipper) {
				for (int i = 0; i < rFlip.getCircles().size(); i++) {
					time = Geometry.timeUntilCircleCollision(rFlip.getCircles().get(i), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(rFlip.getCircles().get(i).getCenter(),
								b.getCircle().getCenter(), b.getVelo(), 1.0);
					}
				}
			} 
			for (LeftFlipper lFlip : lFlipper) {
				for (int i = 0; i < lFlip.getCircles().size(); i++) {
					time = Geometry.timeUntilCircleCollision(lFlip.getCircles().get(i), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(lFlip.getCircles().get(i).getCenter(),
								b.getCircle().getCenter(), b.getVelo(), 1.0);
					}
				}
			} 
			for (LeftFlipper lFlip : lFlipper) {
				for (int i = 0; i < lFlip.getLines().size(); i++) {
					time = Geometry.timeUntilWallCollision(lFlip.getLines().get(i), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectWall(lFlip.getLines().get(i), b.getVelo(), 1.0);

					}
				}

			

		}
		return new CollisionDetails(shortestTime, newVelo);
	}

	public void setBallSpeed(int x, int y, Ball b) {
		b.setVelo(new Vect(x, y));
	}

	public void applyGravity(double time, Ball b) {
		Vect newVelo = new Vect(b.getVelo().getX(), (b.getVelo().getY() + (GRAVITY*time)));
		b.setVelo(newVelo);
	
	}

	public void applyFriction(double time, Ball b) {
		Vect newVelo = new Vect(b.getVelo().getX()*(1-(MU*time)-((MU2/25*b.getVelo().getX())*time)), 
		b.getVelo().getY()*(1-(MU*time)-((MU2/25*b.getVelo().getY())*time)));
		b.setVelo(newVelo);
	}

	public void shootBall() { 
		
		for (Ball b: ball) {
		b.start();
		//b.setExactX(490);
		//	ball.setExactY(25);
		Vect newVelo = new Vect(0, -800);
		b.setVelo(newVelo);
		}
	}

	public void addTriangleBumper(double x, double y) { 

		String ID = "T" + (Triangle.size());

		Triangle.add(new TriangleBumper(ID, x+12.5, y+12.5));
		sqOccupied((int)x, (int)y);
		this.setChanged();
		this.notifyObservers();

	}

	public void addSquareBumper(double x, double y) { 

		String ID = "S" + (int)x + (int)(y-25);

		SBumper.add(new SquareBumper(ID, x, y));
		sqOccupied((int)x, (int)y-25);
		this.setChanged();
		this.notifyObservers();

	}

	public void addLFlipper(double x, double y) { 

		String ID = "LF" + (int)x + (int)y;

		lFlipper.add(new LeftFlipper(ID, x, y));
		sqOccupied((int)x, (int)y);
		sqOccupied((int)x, (int)y+25);
		this.setChanged();
		this.notifyObservers();

	}

	public void addRFlipper(double x, double y) { 

		String ID = "RF" + (int)x + (int)y;

		rFlipper.add(new RightFlipper(ID, x, y));
		sqOccupied((int)x, (int)y);
		sqOccupied((int)x, (int)y+25);
		this.setChanged();
		this.notifyObservers();

	}

	public void addCircleBumper(double x, double y) { 

		String ID = "C" + (int)(x-12) + (int)(y-12);

		CBumper.add(new CircleBumper(ID, x, y));
		sqOccupied((int)x, (int)y);
		this.setChanged();
		this.notifyObservers();

	}
	
	public void addBall(double x, double y) { 

		String ID = "B";
		
		double xVel = 0.0;
		double yVel = 0.0;
		

		ball.add(new Ball(ID, x, y, xVel, yVel));
	
		sqOccupied((int)x, (int)y);
		this.setChanged();
		this.notifyObservers();

	}
	
	public void removeAbsorber() { 

		
		absorb.remove(0);
		
		removeSqOccupied(0, 0);
		removeSqOccupied(0, 25);
		removeSqOccupied(0, 50);
		removeSqOccupied(0, 75);
		removeSqOccupied(0, 100);
		removeSqOccupied(0, 125);
		removeSqOccupied(0, 150);
		removeSqOccupied(0, 175);
		removeSqOccupied(0, 200);
		removeSqOccupied(0, 225);
		removeSqOccupied(0, 250);
		removeSqOccupied(0, 275);
		removeSqOccupied(0, 300);
		removeSqOccupied(0, 325);
		removeSqOccupied(0, 350);
		removeSqOccupied(0, 375);
		removeSqOccupied(0, 400);
		removeSqOccupied(0, 425);
		removeSqOccupied(0, 450);
		removeSqOccupied(0, 475);
		
		
		this.setChanged();
		this.notifyObservers();

	}
	
	
	
	public void addAbsorber() { 

		String ID = "A";

		absorb.add(new Absorber(ID, 0, 475, 500, 500));
		
		sqOccupied(0, 0);
		sqOccupied(0, 25);
		sqOccupied(0, 50);
		sqOccupied(0, 75);
		sqOccupied(0, 100);
		sqOccupied(0, 125);
		sqOccupied(0, 150);
		sqOccupied(0, 175);
		sqOccupied(0, 200);
		sqOccupied(0, 225);
		sqOccupied(0, 250);
		sqOccupied(0, 275);
		sqOccupied(0, 300);
		sqOccupied(0, 325);
		sqOccupied(0, 350);
		sqOccupied(0, 375);
		sqOccupied(0, 400);
		sqOccupied(0, 425);
		sqOccupied(0, 450);
		sqOccupied(0, 475);
		
		
		this.setChanged();
		this.notifyObservers();

	}
	
	
	
	public int rounder(int val) {
		
		int result = 0;
		result = val-(val%25);
		System.out.println(result);
		
		return result;
		
	}
	
public void removeCBumper(String id) {
	
		
		Iterator <CircleBumper> cItr = CBumper.iterator();
		
		while (cItr.hasNext()) { 
			CircleBumper c = cItr.next();
	
		if (id.equals(c.getID())) {
			cItr.remove();
		}
		
		this.setChanged();
		this.notifyObservers();
				
		
	}
		}
	
	public void removeBall(String id) {
	
		
		Iterator <Ball> bItr = ball.iterator();
		
		while (bItr.hasNext()) { 
			Ball b = bItr.next();
		if (id.equals(b.getID())) {
			bItr.remove();
		}
		
		this.setChanged();
		this.notifyObservers();
				
		
	}
		}
	
	public void removeTBumper(int x, int y) {
	
		
		Iterator <TriangleBumper> tItr = Triangle.iterator();
		
		while (tItr.hasNext()) { 
			TriangleBumper t = tItr.next();
		if (t.getExactX()-12.5 == x && t.getExactY()-12.5 == y) {
			tItr.remove();
		}
		
		this.setChanged();
		this.notifyObservers();
				
		
	}
		}
	
	public void rotateTBumper(int x, int y) {
		
				Iterator<TriangleBumper> tItr = Triangle.iterator();
		
				while (tItr.hasNext()) {
					TriangleBumper t = tItr.next();
					if (t.getExactX() - 12.5 == x && t.getExactY() - 12.5 == y) {
		
						System.out.println(t.getDegree());
						
						t.setDegree90();
					}
		
					this.setChanged();
					this.notifyObservers();
		
		 		}
			
			}
	
	public void removeSBumper(String id) {
		
		Iterator <SquareBumper> sqItr = SBumper.iterator();
		
		while (sqItr.hasNext()) { 
			SquareBumper sq = sqItr.next();
	
		if (id.equals(sq.getID())) {
			sqItr.remove();
		}
		
		this.setChanged();
		this.notifyObservers();
				
		
	}
		}
	
	public void removeRFlipper(String id) {
		
		Iterator <RightFlipper> rfItr = rFlipper.iterator();
		
		while (rfItr.hasNext()) { 
			RightFlipper rf = rfItr.next();
		if (id.equals(rf.getID())) {
			rfItr.remove();
		}
		
		this.setChanged();
		this.notifyObservers();
				
		
	}
		}
	
	public void removeLFlipper(String id) {
		
		Iterator <LeftFlipper> lfItr = lFlipper.iterator();
		
		while (lfItr.hasNext()) { 
			LeftFlipper leftf = lfItr.next();
		if (id.equals(leftf.getID())) {
			lfItr.remove();
		}
		
		this.setChanged();
		this.notifyObservers();
				
		
	}
		}
	

	public void quitGame(){
		System.exit(0);
	}
	
	public void clearBoard(){
		absorb.removeAll(absorb); 
		rFlipper.removeAll(rFlipper); 
		lFlipper.removeAll(lFlipper); 
		CBumper.removeAll(CBumper); 
		SBumper.removeAll(SBumper); 
		Triangle.removeAll(Triangle); 
		ball .removeAll(ball); 
		occupiedSq = new boolean[20][20];
		this.setChanged();
		this.notifyObservers();
	}

	public void loadGame(String path) throws FileNotFoundException {

		File file = new File(path);
		Scanner input = new Scanner(file);

		while (input.hasNext()) {
			createGizmo(input.nextLine());
		}
		this.setChanged();
		this.notifyObservers();

	}

	public void saveGame(String path) throws IOException{
		BufferedWriter bw = null;
		FileWriter fw = new FileWriter(path);

		try {

			bw = new BufferedWriter(fw);
			
			for(Absorber a: absorb){
				bw.write("Absorber" + " " + a.getID() + " " + ((int)a.getX()/25) + " " + ((int)a.getY()/25) + " " + 20 + " " +  ((int)a.getWidth()/25));
				bw.newLine();
			}
			for(TriangleBumper t: Triangle){
				bw.write("Triangle" + " " + t.getID() + " " + ((int)(t.getExactX()-12.5)/25) + " " + ((int)(t.getExactY()-12.5)/25));
				bw.newLine();
				if(t.getDegree()==90){
					bw.write("Rotate " + t.getID());
					bw.newLine();
				}
				else if(t.getDegree()==180){
					bw.write("Rotate " + t.getID());
					bw.newLine();
					bw.write("Rotate " + t.getID());
				}
				else if(t.getDegree()==270){
					bw.write("Rotate " + t.getID());
					bw.newLine();
					bw.write("Rotate " + t.getID());
					bw.newLine();
					bw.write("Rotate " + t.getID());
					bw.newLine();
				}
			}
			for(SquareBumper s: SBumper){
				bw.write("Square" + " " + s.getID() + " " + ((int)s.getExactX()/25) + " " + ((int)(s.getExactY()-25)/25));
				bw.newLine();
			}
			
			for(CircleBumper c: CBumper){
				bw.write("Circle" + " " + c.getID() + " " + ((int)(c.getExactX()-12.5)/25) + " " + ((int)(c.getExactY()-12.5)/25));
				bw.newLine();
			}
			for(Ball b: ball){
				bw.write("Ball" + " " + b.getID() + " " + ((int)b.getExactX()/25) + " " + ((int)b.getExactY()/25) + " " + 0 + " " +  0);
				bw.newLine();
			}
			for(RightFlipper rf: rFlipper){
				bw.write("RightFlipper" + " " + rf.getID() + " " + ((int)(rf.getXpos()-40)/25) + " " + ((int)rf.getYpos()/25));
				bw.newLine();
			}
			for(LeftFlipper lf: lFlipper){
				bw.write("LeftFlipper" + " " + lf.getID() + " " + ((int)lf.getXpos()/25) + " " + ((int)lf.getYpos()/25));
				bw.newLine();
			}
			

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}


	}

	public void createGizmo(String gizmo) {

		StringTokenizer st = new StringTokenizer(gizmo);
		ArrayList<String> words = new ArrayList<>();
		while (st.hasMoreTokens()) {
			words.add(st.nextToken());

		}

		if (words.size() > 0) {
			// System.out.println(words.get(0));
			if (words.get(0).equals("Triangle")) {
				Triangle.add(new TriangleBumper(words.get(1), (Double.parseDouble(words.get(2)) * 25) + 12.5,
						(Double.parseDouble(words.get(3)) * 25) + 12.5));
			}
			if (words.get(0).equals("Square")) {
				SBumper.add(new SquareBumper(words.get(1), (Double.parseDouble(words.get(2)) * 25),
						(Double.parseDouble(words.get(3)) * 25+25)));
			}
			if (words.get(0).equals("Circle")) {
				CBumper.add(new CircleBumper(words.get(1), (Double.parseDouble(words.get(2)) * 25) + 12.5,
						(Double.parseDouble(words.get(3)) * 25) + 12.5));
			}
			if (words.get(0).equals("RightFlipper")) {
				rFlipper.add(new RightFlipper(words.get(1), (Integer.parseInt(words.get(2)) * 25) + 40,
						Integer.parseInt(words.get(3)) * 25));
			}
			if (words.get(0).equals("LeftFlipper")) {
				lFlipper.add(new LeftFlipper(words.get(1), (Integer.parseInt(words.get(2)) * 25),
						(Integer.parseInt(words.get(3)) * 25)));
			}
			if (words.get(0).equals("Absorber")) {
				absorb.add(new Absorber(words.get(1), Integer.parseInt(words.get(2)) * 25,
						Integer.parseInt(words.get(3)) * 25, Integer.parseInt(words.get(4)) * 25,
						Integer.parseInt(words.get(5)) * 25));
			}
			if (words.get(0).equals("Ball")) {
				ball.add(new Ball(words.get(1), Double.parseDouble(words.get(2)) * 25,
						Double.parseDouble(words.get(3)) * 25, Double.parseDouble(words.get(4)),
						Double.parseDouble(words.get(5))));
				//				ball.setVelo(new Vect(0,0));
			}
			if (words.get(0).equals("Rotate")) {
				for (int i = 0; i < Triangle.size(); i++) {
					if (Triangle.get(i).getID().equals(words.get(1))) {
						Triangle.get(i).setDegree90();
					
					}
				}
			}

		}

	}


}

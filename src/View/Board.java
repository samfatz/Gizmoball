package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Model.Absorber;
import Model.Ball;
import Model.CircleBumper;
import Model.CollisionDetails;
import Model.LeftFlipper;
import Model.Model;
import Model.RightFlipper;
import Model.SquareBumper;
import Model.TriangleBumper;

public class Board extends JPanel implements Observer {

	protected int width;
	protected int height;
	protected Model m;

	public Board(int w, int h, Model m) {

		width = w;
		height = h;
		this.m = m;
		m.addObserver(this);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.lightGray);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		ArrayList<Ball> B = m.getBall();
		for (Ball b : B) {
		if (b != null) {
			g2.setColor(b.getColour());
			int x = (int) (b.getExactX() - b.getRadius());
			int y = (int) (b.getExactY() - b.getRadius());
			int width = (int) (2 * b.getRadius());
			g2.fillOval(x, y, width, width);
		}
		}
		
		ArrayList<CircleBumper> CB = m.getCBumper();
		for (CircleBumper Cbump : CB) {
			if (Cbump != null) {
				g2.setColor(Cbump.getColour());
				int x1 = (int) (Cbump.getExactX() - Cbump.getRadius());
				int y1 = (int) (Cbump.getExactY() - Cbump.getRadius());
				int width1 = (int) (2 * Cbump.getRadius());
				g2.fillOval(x1, y1, width1, width1);
			}
		}

		ArrayList<SquareBumper> SB = m.getSBumper();
		for (SquareBumper Sbump : SB) {
			if (Sbump != null) {
				for (int i = 0; i < Sbump.getCircles().size(); i++) {
					g2.setColor(Sbump.getColour());
					int x3 = (int) (Sbump.getCircles().get(i).getCenter().getX() - Sbump.getRadius());
					int y3 = (int) (Sbump.getCircles().get(i).getCenter().getY() - Sbump.getRadius());
					int width3 = (int) (2 * Sbump.getRadius());
					g2.fillOval(x3, y3, width3, width3);
					
				}
				
				g2.setColor(Color.black);

				g2.fillRect((int) Sbump.getCircles().get(3).getCenter().getX(),
						(int) Sbump.getCircles().get(3).getCenter().getY() ,(int) Sbump.getWidth() , (int) Sbump.getWidth());
			}

		} 
		
		int[] yArray = new int[3];
		int[] xArray = new int[3];

		ArrayList<TriangleBumper> TB = m.getTB();
		for (TriangleBumper Tbump : TB) {
			if (Tbump != null) {
				for (int i = 0; i < Tbump.getCircles().size(); i++) {

					g2.setColor(Tbump.getColour());
					int x3 = (int) (Tbump.getCircles().get(i).getCenter().getX() - Tbump.getRadius());
					int y3 = (int) (Tbump.getCircles().get(i).getCenter().getY() - Tbump.getRadius());
					yArray[i] = (int) (Tbump.getCircles().get(i).getCenter().getY());
					xArray[i] = (int) (Tbump.getCircles().get(i).getCenter().getX());
					int width3 = (int) (2 * Tbump.getRadius());
					g2.fillOval(x3, y3, width3, width3);
				}
				Polygon poly = new Polygon(xArray, yArray, 3);

				AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(( 0)), Tbump.getExactX(), Tbump.getExactY());
				Shape triangle = at.createTransformedShape(poly);


				g2.fill(triangle);
				
			}

		}
		ArrayList<RightFlipper> RF = m.getRF();
		for (RightFlipper rFlip : RF) {
			if (rFlip != null) {
				RoundRectangle2D rightFlipper = new RoundRectangle2D.Double(rFlip.getXpos(), rFlip.getYpos(),
						rFlip.getWidth(), 10, 10, 50);
				for (int i = 0; i < rFlip.getCircles().size(); i++) {
					g2.setColor(rFlip.getColour());
					int x3 = (int) (rFlip.getCircles().get(i).getCenter().getX() - 5);
					int y3 = (int) (rFlip.getCircles().get(i).getCenter().getY() - 5);
					int width3 = (int) (2 * 5);
					g2.fillOval(x3, y3, width3, width3);
					
				}

				AffineTransform rightAffineTransform = AffineTransform.getRotateInstance(Math.toRadians(( -1 * rFlip.getDegree())), rFlip.getXpos()+5, rFlip.getYpos()+5);
				Shape rightRotatedShape = rightAffineTransform.createTransformedShape(rightFlipper);

				g2.fill(rightRotatedShape);
			}

		}
		ArrayList<LeftFlipper> LF = m.getLF();
		for (LeftFlipper lFlip : LF) {
			if (lFlip != null) {
				RoundRectangle2D leftFlipper = new RoundRectangle2D.Double(lFlip.getXpos(), lFlip.getYpos(),
						lFlip.getWidth(), 10, 10, 50);
				for (int i = 0; i < lFlip.getCircles().size(); i++) {
					g2.setColor(lFlip.getColour());
					int x3 = (int) (lFlip.getCircles().get(i).getCenter().getX()-5);
					int y3 = (int) (lFlip.getCircles().get(i).getCenter().getY()-5);
					int width3 = (int) (2 * 5);
					System.out.println(x3 +" "+ y3);
					g2.fillOval(x3, y3, width3, width3);
					
				}

				AffineTransform rightAffineTransform = AffineTransform.getRotateInstance(Math.toRadians(( -1 * lFlip.getDegree())), lFlip.getXpos()+5, lFlip.getYpos()+5);
				Shape leftRotatedShape = rightAffineTransform.createTransformedShape(leftFlipper);

				g2.fill(leftRotatedShape);
			}

		}
		ArrayList<Absorber> absorb = m.getAbsorb();
		for (Absorber ab : absorb) {
			if (ab != null) {
				
				g2.setColor(ab.getColour());
				g2.fillRect((int)ab.getX(), (int)ab.getY(), (int)ab.getWidth(), 50);
			}

		}
		
				if(m.getRunMode() == false){
					for (int i = 0; i <= getSize().width; i += 25) 
			        {
			           g2.drawLine(i, 0, i, getSize().height);
			           g2.setColor(Color.BLACK);
			        }
			
			        for (int i = 0; i <= getSize().height; i += 25) 
			        {
			           g2.drawLine(0,i, getSize().width, i);
			           g2.setColor(Color.BLACK);
			        }
					}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();

	}
}
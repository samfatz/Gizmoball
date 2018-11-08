package Testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.*;
import physics.Vect;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Grant on 21/03/2018.
 */
class ModelTest
{
    private Model testModel;
    CircleBumper circleBumper1 = new CircleBumper("circle1", 20, 20);
    CircleBumper circleBumper2;
    TriangleBumper triangleBumper = new TriangleBumper("triangle1", 10, 10);
    TriangleBumper triangleBumper2;
    SquareBumper squareBumper1 = new SquareBumper("square1", 15, 15);
    SquareBumper squareBumper2;
    RightFlipper rflipper = new RightFlipper("rf",50,50);
    LeftFlipper lflipper = new LeftFlipper("lf",50,50);
    Absorber absorber = new Absorber("absorber1", 10,10,10,10);
    TriangleBumper t1 = new TriangleBumper("t1", 5, 5);
    SquareBumper sb1 = new SquareBumper("sb1", 10, 10);
    SquareBumper sb2 = new SquareBumper("sb1", 20, 20);
    Ball ball = new Ball("ball1",20,20,10,10);



    @BeforeEach
    void setUp()
    {
        testModel = new Model();

    }

    @Test
    void sqOccupied()
    {
        testModel.addSquareBumper(12,12);
        assertTrue(testModel.getOccupiedSq(12,12));
    }

    @Test
    void checkTaken()
    {
        testModel.addSquareBumper(12,12);
        assertTrue(testModel.checkTaken(12,12));
    }

    @Test
    void removeSqOccupied()
    {
        testModel.addSquareBumper(12,12);
        assertTrue(testModel.checkTaken(12,12));

        testModel.removeSqOccupied(12,12);
        assertFalse(testModel.checkTaken(12,12));
    }

    @Test
    void flipRightFlipper()
    {
        testModel.addRFlipper(30, 30);
        testModel.addRFlipper(49, 59);
        testModel.addRFlipper(20, 10);
        testModel.addRFlipper(5, 5);
        testModel.addRFlipper(10, 20);



        for (RightFlipper rf: testModel.getRF())
        {
            double testDegree = rf.getDegree();
            rf.flip();
            assertEquals(testDegree - 30, rf.getDegree());
        }
    }

    @Test
    void unflipRightFlipper()
    {
        testModel.addRFlipper(30, 30);
        testModel.addRFlipper(49, 59);
        testModel.addRFlipper(20, 10);
        testModel.addRFlipper(5, 5);
        testModel.addRFlipper(10, 20);



        for (RightFlipper rf: testModel.getRF())
        {

            rf.flip();
            double testDegree = rf.getDegree();
            rf.unFlip();
            assertEquals(testDegree + 10, rf.getDegree());
        }
    }

    @Test
    void flipLeftFlipper()
    {
        testModel.addLFlipper(30, 30);
        testModel.addLFlipper(49, 59);
        testModel.addLFlipper(20, 10);
        testModel.addLFlipper(5, 5);
        testModel.addLFlipper(10, 20);



        for (LeftFlipper lf: testModel.getLF())
        {
            double testDegree = lf.getDegree();
            lf.flip();
            assertEquals(testDegree + 90, lf.getDegree());
        }
    }

    @Test
    void unflipLeftFlipper()
    {
        testModel.addLFlipper(30, 30);
        testModel.addLFlipper(49, 59);
        testModel.addLFlipper(20, 10);
        testModel.addLFlipper(5, 5);
        testModel.addLFlipper(10, 20);



        for (LeftFlipper lf: testModel.getLF())
        {

            lf.flip();
            double testDegree = lf.getDegree();
            lf.unFlip();
            assertEquals(testDegree -90, lf.getDegree());
        }
    }

    //@Test
//    void moveBall()
//    {
//        testModel.addBall(25, 25);
//        Ball testBall = testModel.getBall().get(0);
//        double oldX = testBall.getExactX();
//        double oldY = testBall.getExactY();
//
//        testModel.moveBall();
//
//        assertNotEquals(oldX, testBall.getExactX());
//        assertNotEquals(oldY, testBall.getExactY());
//    }

    @Test
    void stopBalls()
    {
        testModel.addBall(5,5);
        testModel.addBall(25,25);
        testModel.addBall(25,60);
        testModel.addBall(40,25);
        testModel.addBall(4,25);

        for (Ball b: testModel.getBall())
        {
            b.stop();
            assertTrue(b.stopped());
        }


    }

    @Test
    void startBalls()
    {
        testModel.addBall(5,5);
        testModel.addBall(25,25);
        testModel.addBall(25,60);
        testModel.addBall(40,25);
        testModel.addBall(4,25);

        for (Ball b: testModel.getBall())
        {
            b.start();
            assertFalse(b.stopped());
        }
    }

    @Test
    void applyGravity()
    {
        testModel.addBall(25,25);
        Ball testBall = testModel.getBall().get(0);
        Vect oldVect = testBall.getVelo();

        testModel.applyGravity(100, testBall);
        assertNotEquals(oldVect, testBall.getVelo());

    }

    @Test
    void applyFriction()
    {
        testModel.addBall(25,25);
        Ball testBall = testModel.getBall().get(0);
        Vect oldVect = testBall.getVelo();

        testModel.applyFriction(1000, testBall);
        testModel.moveBall();
        assertNotEquals(oldVect, testBall.getVelo());
    }

    @Test
    void shootBall()
    {
        testModel.addBall(5,5);
        testModel.addBall(25,25);
        testModel.addBall(25,60);
        testModel.addBall(40,25);
        testModel.addBall(4,25);
        testModel.addAbsorber();

        ArrayList<Ball> testBalls = new ArrayList<Ball>();

        for (Ball b: testModel.getBall())
        {
            Ball tempBall = new Ball("test", 25, 40, 0, 0);
            tempBall.setVelo(b.getVelo());
            testBalls.add(tempBall);
        }

        testModel.shootBall();

        for (int i = 0; i < testBalls.size(); i++)
        {
            assertNotEquals(testBalls.get(i).getVelo(), testModel.getBall().get(i).getVelo());
        }

    }

    @Test
    void addTriangleBumper() {
        assertEquals("triangle1",triangleBumper.getID());
        assertEquals(10, triangleBumper.getExactX());
        assertEquals(10, triangleBumper.getExactY());
        assertTrue(triangleBumper != null);
        assertFalse(triangleBumper == triangleBumper2);
    }

    @Test
    void addSquareBumper() {
        assertEquals(15,squareBumper1.getExactX());
        assertEquals(15,squareBumper1.getExactY());
        assertEquals(0,squareBumper1.getRadius());
        assertEquals(25,squareBumper1.getWidth());
        assertTrue(squareBumper1 != null);
        assertFalse(squareBumper1.equals(circleBumper1));
        assertFalse(squareBumper1 == squareBumper2);
    }

    @Test
    void addLFlipper() {
        LeftFlipper lflipper2 = new LeftFlipper("lf",50,50);
        assertEquals(50,lflipper.getXpos());
        assertEquals(50,lflipper.getYpos());
        assertEquals(50,lflipper.getWidth());
        assertEquals(-90,lflipper.getDegree());
        assertFalse(lflipper == lflipper2);
        assertTrue(lflipper != null);
    }

    @Test
    void addRFlipper() {
        RightFlipper rflipper2 = new RightFlipper("rf",50,50);
        assertEquals(50,rflipper.getXpos());
        assertEquals(50,rflipper.getYpos());
        assertEquals(50,rflipper.getWidth());
        assertEquals(-90,rflipper.getDegree());
        assertFalse(rflipper == rflipper2);
        assertTrue(rflipper != null);
    }

    @Test
    void addCircleBumper() {
        assertNotNull(circleBumper1);
        assertEquals(20,circleBumper1.getExactY());
        assertEquals(20,circleBumper1.getExactX());
        assertEquals(12.5D, circleBumper1.getRadius());
        assertTrue(circleBumper1 != null);
        assertFalse(circleBumper1 == circleBumper2);
    }

    @Test
    void addBall() {
        assertEquals(6.25,ball.getRadius());
        assertEquals(20,ball.getExactX());
        assertEquals(20, ball.getExactY());
        assertTrue(ball != null);
    }

    @Test
    void addAbsorber() {
        Absorber absorber2 = new Absorber("absorber2", 15,15,15,15);
        assertFalse(absorber == absorber2);
        assertTrue(absorber != null);
        assertEquals(10, absorber.getX());
        assertEquals(10, absorber.getY());
        assertEquals(10,absorber.getWidth());
    }

    @Test
    public void testMoveBumper(){
        //String ID = "S" + x + y;
        SquareBumper squareBumper3 = new SquareBumper("sqaure3", 10, 10);
        assertTrue(squareBumper3 == squareBumper3);
        assertEquals(10,squareBumper3.getExactX());
        assertEquals(10,squareBumper3.getExactY());
        System.out.println("X: "+squareBumper3.getExactX());
        System.out.println("Y: "+squareBumper3.getExactY());
        squareBumper3 = new SquareBumper("sqaure3", 20, 20);
        assertEquals(20,squareBumper3.getExactX());
        assertEquals(20,squareBumper3.getExactY());
        System.out.println("New X: "+squareBumper3.getExactX());
        System.out.println("New Y: "+squareBumper3.getExactY());
    }

    @Test
    public void testMoveAbsorber()
    {
        Absorber absorber3 = new Absorber("ab3", 25, 25, 25, 25);
        assertTrue(absorber3== absorber3);
        assertEquals(25,absorber3.getY());
        assertEquals(25,absorber3.getX());
        System.out.println("X: "+absorber3.getX());
        System.out.println("Y: "+absorber3.getY());
        absorber3 = new Absorber("ab3", 20, 20, 20, 20);
        assertEquals(20,absorber3.getX());
        assertEquals(20,absorber3.getY());
        System.out.println("New X: "+absorber3.getX());
        System.out.println("New Y: "+absorber3.getY());
    }

    @Test
    public void testMoveFlipper()
    {
        Flipper flipper1 = new Flipper(22,22,22,90);
        assertTrue( flipper1 == flipper1);
        assertEquals(22,flipper1.getYpos());
        assertEquals(22,flipper1.getXpos());
        System.out.println("X: "+flipper1.getXpos());
        System.out.println("Y: "+flipper1.getYpos());
        flipper1 = new Flipper(30,30,30,180);
        assertEquals(30,flipper1.getXpos());
        assertEquals(30,flipper1.getYpos());
        System.out.println("New X: "+flipper1.getXpos());
        System.out.println("New Y: "+flipper1.getYpos());
    }



    @Test
    void rounder() {

    }

    @Test
    void removeCBumper()
    {
        testModel.addCircleBumper(5,5);
        testModel.addCircleBumper(5,10);
        testModel.addCircleBumper(5,15);
        testModel.addCircleBumper(5,20);
        testModel.addCircleBumper(5,25);

        int numberOfCircles = testModel.getCBumper().size();

        testModel.removeCBumper("C" + (5-12) + (5-12));



        assertNotEquals(numberOfCircles, testModel.getCBumper().size());


    }

    @Test
    void removeBall() {

    }

    @Test
    void removeTBumper()
    {

        testModel.addTriangleBumper(5,5);
        testModel.addTriangleBumper(5,10);
        testModel.addTriangleBumper(5,15);
        testModel.addTriangleBumper(5,20);
        testModel.addTriangleBumper(5,25);

        int numberOfTriangles = testModel.getTB().size();

        testModel.removeTBumper(5,5);

        assertNotEquals(numberOfTriangles, testModel.getTB().size());

    }

    @Test
    void rotateTBumper() {

    }

    @Test
    void removeSBumper() {
        ArrayList<SquareBumper> SBumper = new ArrayList<>();
        assertTrue(SBumper.isEmpty());
        SBumper.add(sb1);
        SBumper.add(sb2);        RightFlipper rightFlipper = new RightFlipper("rf1",35,10);
        RightFlipper rightFlipper2 = new RightFlipper("rf2",40,15);
        ArrayList<RightFlipper> rFlipper = new ArrayList<>();
        assertTrue(rFlipper.isEmpty());
        rFlipper.add(rightFlipper);
        rFlipper.add(rightFlipper2);
        assertFalse(rFlipper.isEmpty());
        assertTrue(rFlipper != null);
        System.out.println(rFlipper.size());
        rFlipper.remove(rightFlipper);
        System.out.println(rFlipper.size());
        rFlipper.remove(rightFlipper2);
        System.out.println(rFlipper.size());
        assertTrue(rFlipper.isEmpty());
        System.out.println(SBumper.size());
        assertTrue(SBumper != null);
        SBumper.remove(sb1);
        SBumper.remove(sb2);
        System.out.println(SBumper.size());
        assertTrue(SBumper.isEmpty());
    }

    @Test
    void removeRFlipper() {
        RightFlipper rightFlipper = new RightFlipper("rf1",35,10);
        RightFlipper rightFlipper2 = new RightFlipper("rf2",40,15);
        ArrayList<RightFlipper> rFlipper = new ArrayList<>();
        assertTrue(rFlipper.isEmpty());
        rFlipper.add(rightFlipper);
        rFlipper.add(rightFlipper2);
        assertFalse(rFlipper.isEmpty());
        assertTrue(rFlipper != null);
        System.out.println(rFlipper.size());
        rFlipper.remove(rightFlipper);
        System.out.println(rFlipper.size());
        rFlipper.remove(rightFlipper2);
        System.out.println(rFlipper.size());
        assertTrue(rFlipper.isEmpty());
    }

    @Test
    void removeLFlipper() {

    }

    @Test
    void quitGame() {

    }

    @Test
    void clearBoard() {

    }

    @Test
    void loadGame() {

    }

    @Test
    void saveGame() {

    }

    @Test
    void createGizmo() {

    }

}
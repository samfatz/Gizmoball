package Testing;

import Model.RightFlipper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Grant on 20/03/2018.
 */
class RightFlipperTest
{
    private RightFlipper testRightFlipper;
    ArrayList<Circle> testCircles;
    ArrayList<LineSegment> testLines;
    @BeforeEach
    void setUp()
    {
        testRightFlipper = new RightFlipper("testRightFlipper", 10, 10);
    }

    @Test
    void flip()
    {
       double testDegree = testRightFlipper.getDegree();
       testRightFlipper.flip();
       assertEquals(testDegree - 30, testRightFlipper.getDegree());

      testCircles = testRightFlipper.getCircles();
      assertEquals(2, testCircles.size());

      testLines = testRightFlipper.getLines();
      assertEquals(2, testLines.size());

    }

    @Test
    void unFlip()
    {
        testRightFlipper.flip();
        double testDegree = testRightFlipper.getDegree();
        testRightFlipper.unFlip();
        assertEquals(testDegree + 10, testRightFlipper.getDegree());

        testCircles = testRightFlipper.getCircles();
        assertEquals(2, testCircles.size());

        testLines = testRightFlipper.getLines();
        assertEquals(2, testLines.size());
    }

}
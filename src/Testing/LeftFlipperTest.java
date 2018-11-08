package Testing;

import Model.LeftFlipper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Grant on 20/03/2018.
 */
class LeftFlipperTest
{
    private LeftFlipper testLeftFlipper;
    ArrayList<Circle> testCircles;
    ArrayList<LineSegment> testLines;

    @BeforeEach
    void setUp()
    {
        testLeftFlipper = new LeftFlipper("testLeftFlipper", 10, 10);
    }

    @Test
    void flip()
    {
        testLeftFlipper.flip();
        assertEquals(0, testLeftFlipper.getDegree());

        testCircles = testLeftFlipper.getCircles();
        assertEquals(2, testCircles.size());

        testLines = testLeftFlipper.getLines();
        assertEquals(2, testLines.size());
    }

    @Test
    void unFlip()
    {

        testLeftFlipper.unFlip();
        assertEquals(-90, testLeftFlipper.getDegree());

        testCircles = testLeftFlipper.getCircles();
        assertEquals(2, testCircles.size());

        testLines = testLeftFlipper.getLines();
        assertEquals(2, testLines.size());
    }

}
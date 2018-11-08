package Testing;

import Model.Flipper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Grant on 20/03/2018.
 */
class FlipperTest
{
    private Flipper testFlipper;


    @BeforeEach
    void setUp()
    {
        testFlipper = new Flipper(10, 10, 10, 90);
    }

    @Test
    void flipRight()
    {
        testFlipper.flipRight();
        assertEquals(0, testFlipper.getDegree());
    }

    @Test
    void flipLeft()
    {
        testFlipper.flipLeft();
        assertEquals(180, testFlipper.getDegree());
    }

    @Test
    void unFlipRight()
    {
        testFlipper.unFlipRight();
        assertEquals(-90, testFlipper.getDegree());
    }

    @Test
    void unFlipLeft()
    {
        testFlipper.unFlipLeft();
        assertEquals(-90, testFlipper.getDegree());
    }

}
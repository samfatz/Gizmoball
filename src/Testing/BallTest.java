package Testing;
import Model.Ball;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Grant on 20/03/2018.
 */



class BallTest
{
    private  Ball testBall;


    @org.junit.jupiter.api.BeforeEach
    void setUp()
    {
        testBall = new Ball("testBall", 25, 25, 100, 100);
    }

    @org.junit.jupiter.api.Test
    void stop()
    {
        testBall.stop();
        assertTrue(testBall.stopped());

    }

    @org.junit.jupiter.api.Test
    void start()
    {
        testBall.start();
        assertFalse(testBall.stopped());
    }

}
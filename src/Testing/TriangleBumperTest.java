package Testing;

import Model.TriangleBumper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import physics.LineSegment;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Grant on 20/03/2018.
 */
class TriangleBumperTest
{
    private TriangleBumper testTriangleBumper;
    private ArrayList<LineSegment> testLines;
    private int numberOfLines;

    @BeforeEach
    void setUp()
    {
        testTriangleBumper = new TriangleBumper("testTriangleBumper", 25, 25);
        testLines = testTriangleBumper.getLines();
        numberOfLines = testLines.size();
    }

    @Test
    void setDegree90Test0()
    {
            testTriangleBumper.setDegree90();
            assertEquals(90, testTriangleBumper.getDegree());
            assertEquals(numberOfLines + 2, testTriangleBumper.getLines().size());
    }


    @Test
    void setDegree90Test90()
    {

     testTriangleBumper.setDegree(90);
     testTriangleBumper.setDegree90();
     assertEquals(180, testTriangleBumper.getDegree());
     assertEquals(3, testTriangleBumper.getLines().size());

    }

    @Test
    void setDegree90Test180()
    {
        testTriangleBumper.setDegree(180);
        testTriangleBumper.setDegree90();
        assertEquals(270, testTriangleBumper.getDegree());
        assertEquals(3, testTriangleBumper.getLines().size());
    }

    @Test
    void setDegree90Test270()
    {
        testTriangleBumper.setDegree(270);
        testTriangleBumper.setDegree90();
        assertEquals(0, testTriangleBumper.getDegree());
        assertEquals(3, testTriangleBumper.getLines().size());
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Museum2015 on 31/8/2016.
 */
public class validEquationTest {
    @Test
    public void checkValidity1() throws Exception {

    }

    @Test
    public void checkValidity() throws Exception {
        String goodInput = "1 + 1";
        assertTrue(validEquation.checkValidity(goodInput));

        String badInput = "+ +";
        assertFalse(validEquation.checkValidity(badInput));
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

public class validEquationTest {
    @Test
    public void checkValidityTest() throws Exception {
        String goodInput = "1.2 + .2";
        assertTrue(validEquation.checkValidity(goodInput).equals("1.2 + .2"));
    }

    @Test
    public void checkValidityTest2() throws Exception {
        String goodInput = "( 3.00008 + 3.0 ) * 8 + ( 3 / 3 )";
        assertTrue(validEquation.checkValidity(goodInput).equals("( 3.00008 + 3.0 ) * 8 + ( 3 / 3 )"));
    }

    @Test
    public void checkValidityTest3() throws Exception {
        String badInput = "1 + 0.0000 )";
        assertTrue(validEquation.checkValidity(badInput).equals("not valid"));
    }

    @Test
    public void checkValidityTest4() throws Exception {
        String badInput = "1 + 1 + 1 +";
        assertTrue(validEquation.checkValidity(badInput).equals("not valid"));
    }
}
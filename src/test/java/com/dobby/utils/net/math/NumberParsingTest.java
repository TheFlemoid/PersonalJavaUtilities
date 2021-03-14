package com.dobby.utils.math;

import com.dobby.utils.math.NumberParsing;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberParsingTest {
    String validDouble = "13.2957";
    String validDouble2 = "43.295782973";
    String validDouble3 = "-43.23423";
    String validDouble4 = "14";
    String invalidDouble = "13ts.462";
    String invalidDouble2 = "13. 4323453";
    String invalidDouble3 = "-13%.12342134";
    String invalidDouble4 = "";

    @Test
    public void doubleCheckTest() {
        assertTrue(NumberParsing.isValidDouble(validDouble));
        assertTrue(NumberParsing.isValidDouble(validDouble2));
        assertTrue(NumberParsing.isValidDouble(validDouble3));
        assertTrue(NumberParsing.isValidDouble(validDouble4));
        assertFalse(NumberParsing.isValidDouble(invalidDouble));
        assertFalse(NumberParsing.isValidDouble(invalidDouble2));
        assertFalse(NumberParsing.isValidDouble(invalidDouble3));
        assertFalse(NumberParsing.isValidDouble(invalidDouble4));
    }
}

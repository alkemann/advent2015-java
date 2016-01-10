package com.alkemann.advent.five;

import org.junit.Test;
import static org.junit.Assert.*;

public class PresentTwoTest {

    private final PresentTwo present;
    private final PresentTwo present2;

    public PresentTwoTest() {
        present = new PresentTwo("qjhvhtzxzqqjkmpb");
        present2 = new PresentTwo("xxyxx");
    }

    @Test
    public void testIsNice() {
        assertTrue(present.isNice());
        assertTrue(present2.isNice());
    }

    @Test
    public void testIsNaughty() {
        PresentTwo bad = new PresentTwo("uurcxstgmygtbstg");
        assertFalse(bad.isNice());
        bad = new PresentTwo("ieodomkazucvgmuy");
        assertFalse(bad.isNice());
    }

    @Test
    public void testHasRecurring() {
        assertTrue(present.hasRecurring());
        assertTrue(present2.hasRecurring());
        PresentTwo bad = new PresentTwo("ieodomkazucvgmuy");
        assertFalse(bad.hasRecurring());
    }

    @Test
    public void testLookFor() {
        assertTrue(present.lookFor("ea", "peat"));
        assertFalse(present.lookFor("ea", "peet"));
        assertFalse(present.lookFor("aa", "a"));
    }

    @Test
    public void testHasDoubleLetter() {
//        assertTrue(present.hasDoubleLetter());
//        assertTrue(present2.hasDoubleLetter());
        PresentTwo bad = new PresentTwo("123456789");
        assertFalse(bad.hasDoubleLetter());
    }

}

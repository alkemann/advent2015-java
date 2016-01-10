package com.alkemann.advent.five;

import org.junit.Test;
import static org.junit.Assert.*;

public class PresentTest {

    private final Present present;
    private final Present present2;
    
    public PresentTest() {
        present = new Present("ugknbfddgicrmopn");
        present2 = new Present("aaa");

    }

    @Test
    public void testIsNice() {
        assertTrue(present.isNice());
        assertTrue(present2.isNice());
    }

    @Test
    public void testIsNaughty() {
        Present bad = new Present("jchzalrnumimnmhp");
        assertFalse(bad.isNice());
        bad = new Present("haegwjzuvuyypxyu");
        assertFalse(bad.isNice());
        bad = new Present("dvszwmarrgswjxmb");
        assertFalse(bad.isNice());
    }

    @Test
    public void testHasVowels() {
        assertTrue(present.hasVowels());
        assertTrue(present2.hasVowels());
        Present bad = new Present("dvszwmarrgswjxmb");
        assertFalse(bad.hasVowels());
    }

    @Test
    public void testHasRecurring() {
        assertTrue(present.hasRecurring());
        assertTrue(present2.hasRecurring());
        Present bad = new Present("jchzalrnumimnmhp");
        assertFalse(bad.hasRecurring());
    }

    @Test
    public void testHasNoBadPart() {
        assertTrue(present.hasNoBadParts());
        assertTrue(present2.hasNoBadParts());
        Present bad = new Present("haegwjzuvuyypxyu");
        assertFalse(bad.hasNoBadParts());
    }
    
}

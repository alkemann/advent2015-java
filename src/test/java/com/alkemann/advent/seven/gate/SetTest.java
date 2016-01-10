package com.alkemann.advent.seven.gate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetTest {

    @Test
    public void testChangingValueToRun() throws Exception {
        Set setGate = new Set("5", "x");
        assertEquals(5, setGate.getOutput());
        assertEquals("Values do not match", 5, setGate.getInputOne());
    }
}
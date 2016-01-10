package com.alkemann.advent.seven.gate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AndTest {

    @Test
    public void testChangingValueToRun() throws Exception {
        And andGate = new And("5", "15", "a");
        assertEquals("Values dont match", 5, andGate.getInputOne());
        assertEquals("Values dont match", 0b01111, andGate.getInputTwo());
        assertEquals("And operation not worked", 5, andGate.getOutput());
    }
}
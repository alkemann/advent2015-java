package com.alkemann.advent.seven.gate;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrTest {

    @Test
    public void testRun() throws Exception {
        Or orGate = new Or("5", "10", "x");
        assertEquals("And operation not worked", 15, orGate.getOutput());
        assertEquals("Values dont match", 5, orGate.getInputOne());
        assertEquals("Values dont match", 10, orGate.getInputTwo());
    }
}
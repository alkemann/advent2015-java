package com.alkemann.advent.seven.gate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alek on 09.01.2016.
 */
public class RightShiftTest {

    @Test
    public void testRun() throws Exception {
        RightShift rightShiftGate = new RightShift("20", "2", "x");
        assertEquals("Values dont match", 20, rightShiftGate.getInputOne());
        assertEquals("Values dont match", 2, rightShiftGate.getInputTwo());
        assertEquals("And operation not worked", 5, rightShiftGate.getOutput());
    }
}
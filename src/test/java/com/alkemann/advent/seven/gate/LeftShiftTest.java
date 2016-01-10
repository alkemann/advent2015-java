package com.alkemann.advent.seven.gate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alek on 09.01.2016.
 */
public class LeftShiftTest {

    @Test
    public void testRun() throws Exception {
        LeftShift leftShiftGate = new LeftShift("5", "2", "a");
        assertEquals("Values dont match", 5, leftShiftGate.getInputOne());
        assertEquals("Values dont match", 2, leftShiftGate.getInputTwo());
        assertEquals("And operation not worked", 20, leftShiftGate.getOutput());
    }
}
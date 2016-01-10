package com.alkemann.advent.seven.gate;

import com.alkemann.advent.seven.Gate;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotTest {

    @Test
    public void testRun() throws Exception {
        Not setGate = new Not("65522", "x");
        assertEquals(0b1101, setGate.getOutput());
    }
}
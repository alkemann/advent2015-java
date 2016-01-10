package com.alkemann.advent.seven;

import com.alkemann.advent.seven.errors.UnknownGateTypeException;
import com.alkemann.advent.seven.gate.Set;
import org.junit.Test;

import static org.junit.Assert.*;

public class GateTest {

    @Test
    public void testCreateGateFromString() throws UnknownGateTypeException {
        Gate gate = Gate.createFromString("12 -> 12");
        assertEquals(12, gate.getOutput());
        assertTrue(gate instanceof Set);
    }
}
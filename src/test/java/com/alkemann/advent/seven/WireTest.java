package com.alkemann.advent.seven;

import org.junit.Test;

import static org.junit.Assert.*;

public class WireTest {

    @Test
    public void testWire() {
        Wire wire = new Wire("ab");
        assertEquals("ab", wire.name);
    }

}
package com.alkemann.advent.three;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolverTest {

    @Test
    public void testMap() {
        Solver s = new Solver();
        s.solve("^v^v^v^v^v");
        assertEquals(2, s.map.size());
        s.solve("^>v<");
        assertEquals(4, s.map.size());
    }
}
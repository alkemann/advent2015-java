package com.alkemann.advent.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolverTest {

    @Test
    public void testIt() {
        Solver s = new Solver();;
        // A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of wrapping paper plus 6 square feet of slack, for a total of 58 square feet.
        s.paper("2x3x4");
        assertEquals(58, s.area);
        // A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of wrapping paper plus 1 square foot of slack, for a total of 43 square feet.
        s = new Solver();
        s.paper("1x1x10");
        assertEquals(43, s.area);
    }
}
package com.alkemann.advent.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolverTest {

 /*
    (()) and ()() both result in floor 0.
    ((( and (()(()( both result in floor 3.
    ))((((( also results in floor 3.
    ()) and ))( both result in floor -1 (the first basement level).
    ))) and )())()) both result in floor -3.
*/
    @Test
    public void testIt() {
        Solver solver = new Solver();
        assertEquals(0, solver.floor("(())"));
        assertEquals(3, solver.floor("((("));
        assertEquals(3, solver.floor("(()(()("));
        assertEquals(3, solver.floor("))((((("));
        assertEquals(-1, solver.floor("())"));
        assertEquals(-1, solver.floor("))("));
        assertEquals(-3, solver.floor(")))"));
        assertEquals(-3, solver.floor(")())())"));
    }
}
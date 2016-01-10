package com.alkemann.advent.four;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolverTest {

    Solver solver;

    public SolverTest() {
        solver = new Solver();
    }

    @Test
    public void testCheck() {
        assertTrue(solver.check("00000abcfed"));
        assertTrue(solver.check("000001jhsdf"));
        assertTrue(solver.check("000000abcfed"));
        assertTrue(solver.check("0000000bcfed"));
        assertFalse(solver.check("00001bcfed"));
        assertFalse(solver.check("0001bcfed"));
        assertFalse(solver.check("100000bcfedasd2"));
    }

    @Test
    public void testCheckInt() {
        assertTrue(solver.check("00000abcfed", 5));
        assertTrue(solver.check("00001jhsdf", 4));
        assertTrue(solver.check("00abcfed", 2));
        assertTrue(solver.check("0000000bcfed", 7));
        assertFalse(solver.check("00001bcfed", 5));
        assertFalse(solver.check("0001bcfed", 5));
        assertFalse(solver.check("100000bcfedasd2", 3));
    }

    @Test
    public void testPartOne() throws Exception  {
        int expected = 609043;
        int result = solver.mine("abcdef");
//        assertEquals(expected, result);
//        
//        expected = 1048970;
//        result = solver.mine("pqrstuv");
//        assertEquals(expected, result);
        
//        result = solver.mine("ckczppom");
//        System.out.println("Result: " + result);

        result = solver.mine("ckczppom", 6);
        System.out.println("Result: " + result);
    }

    @Test
    public void testMd5() throws Exception {
        assertEquals("000001dbbfa3a5c83a2d506429c7b00e", solver.md5("abcdef609043"));
    }

}

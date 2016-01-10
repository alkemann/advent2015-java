package com.alkemann.advent.seven.gate;

import com.alkemann.advent.seven.Gate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberTest {

    @Test
    public void testIntegerBitwiseShifts() {
        int n = 1;
        int expected = 2;
        int actual = n << 1;
        assertEquals(expected, actual);

        n = 5;
        expected = 2;
        actual = n >> 1;
        assertEquals(expected, actual);

        n = 65535;
        expected = n - 1;
        actual = n << 1 & Gate.MAX;
        assertEquals(expected, actual);

        n = 49153;
        expected = 4;
        actual = n << 2 & Gate.MAX;
        assertEquals(expected, actual);
    }

    @Test
    public void testNotOp() {
        int n = 65535;
        int expected = 0;
        int actual = ~n & Gate.MAX;
        assertEquals(expected, actual);
    }

    @Test
    public void testAndOp() {
        int n1 = 0b0101;
        int n2 = 0b0111;
        int expected = 0b0101;
        int actual = n1 & n2 & Gate.MAX;
        assertEquals(expected, actual);
    }
}

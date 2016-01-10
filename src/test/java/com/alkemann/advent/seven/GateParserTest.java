package com.alkemann.advent.seven;

import com.alkemann.advent.seven.errors.UnknownGateTypeException;
import org.junit.Test;

import static org.junit.Assert.*;

public class GateParserTest {

    @Test
    public void testSet() throws Exception, UnknownGateTypeException {
        GateParser gp = new GateParser("456 -> y");
        assertEquals(gp.inputOne, "456");
        assertEquals(gp.output, "y");
        assertEquals(gp.type, Gate.Type.SET);
    }

    @Test
    public void testNot() throws Exception, UnknownGateTypeException {
        GateParser gp = new GateParser("NOT 456 -> y");
        assertEquals(gp.inputOne, "456");
        assertNull(gp.inputTwo);
        assertEquals(gp.output, "y");
        assertEquals(gp.type, Gate.Type.NOT);
    }

    @Test
    public void testAnd() throws Exception, UnknownGateTypeException {
        GateParser gp = new GateParser("ab AND 12 -> cs");
        assertEquals(gp.inputOne, "ab");
        assertEquals(gp.inputTwo, "12");
        assertEquals(gp.output, "cs");
        assertEquals(gp.type, Gate.Type.AND);
    }

    @Test
    public void testOr() throws Exception, UnknownGateTypeException {
        GateParser gp = new GateParser("xy OR hg -> qwe");
        assertEquals(gp.inputOne, "xy");
        assertEquals(gp.inputTwo, "hg");
        assertEquals(gp.output, "qwe");
        assertEquals(gp.type, Gate.Type.OR);
    }

    @Test
    public void testLeftShift() throws Exception, UnknownGateTypeException {
        GateParser gp = new GateParser("ab LSHIFT 1 -> y");
        assertEquals(gp.inputOne, "ab");
        assertEquals(gp.inputTwo, "1");
        assertEquals(gp.output, "y");
        assertEquals(gp.type, Gate.Type.LSHIFT);
    }

    @Test
    public void testRightShift() throws Exception, UnknownGateTypeException {
        GateParser gp = new GateParser("b RSHIFT a -> y");
        assertEquals(gp.inputOne, "b");
        assertEquals(gp.inputTwo, "a");
        assertEquals(gp.output, "y");
        assertEquals(gp.type, Gate.Type.RSHIFT);
    }

}
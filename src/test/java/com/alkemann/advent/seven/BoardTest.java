package com.alkemann.advent.seven;

import com.alkemann.advent.seven.errors.UnknownGateTypeException;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testMiniBoard() throws UnknownGateTypeException {
        List<String> commands = new ArrayList<String>();
        commands.add("123 -> x");
        commands.add("456 -> y");
        commands.add("x AND y -> d");
        commands.add("x OR y -> e");
        commands.add("x LSHIFT 2 -> f");
        commands.add("y RSHIFT 2 -> g");
        commands.add("NOT x -> h");
        commands.add("NOT y -> i");


        Board board = new Board(commands);

        assertEquals("Not expected output from wire d: ", 72, board.getWireSignal("d"));
        assertEquals("Not expected output from wire e: ", 507, board.getWireSignal("e"));
        assertEquals("Not expected output from wire f: ", 492, board.getWireSignal("f"));
        assertEquals("Not expected output from wire g: ", 114, board.getWireSignal("g"));
        assertEquals("Not expected output from wire h: ", 65412, board.getWireSignal("h"));
        assertEquals("Not expected output from wire i: ", 65079, board.getWireSignal("i"));
        assertEquals("Not expected output from wire x: ", 123, board.getWireSignal("x"));
        assertEquals("Not expected output from wire y: ", 456, board.getWireSignal("y"));
    }
}
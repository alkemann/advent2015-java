package com.alkemann.advent.nine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TravelTest {

    @Test
    public void testAddPart() throws Exception {
        List<String> parts = new ArrayList<String>(3);
        parts.add("London to Dublin = 464");
        parts.add("London to Belfast = 518");
        parts.add("Dublin to Belfast = 141");

        Travel travel = new Travel(parts);

        // London -> Dublin -> Belfast or Belfast -> Dublin -> London
        assertEquals(605, travel.getShortestDistance("London"));
    }
}
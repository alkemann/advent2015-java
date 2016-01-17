package com.alkemann.advent.nine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TravelTest {

    @Test
    public void testGetShortestDistance() throws Exception {
        List<String> parts = new ArrayList<String>(3);
        parts.add("London to Dublin = 464");
        parts.add("London to Belfast = 518");
        parts.add("Dublin to Belfast = 141");

        Travel travel = new Travel(parts);

        assertEquals(605, travel.getShortestDistance("London"));
    }
    public void testGetLongestDistance() throws Exception {
        List<String> parts = new ArrayList<String>(3);
        parts.add("London to Dublin = 464");
        parts.add("London to Belfast = 518");
        parts.add("Dublin to Belfast = 141");

        Travel travel = new Travel(parts);

        assertEquals(982, travel.getLongestDistance("London"));
    }
}
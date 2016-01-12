package com.alkemann.advent.six;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void testIsOn() throws Exception {
        Grid grid = new Grid();
        assertFalse(grid.isOn(1, 1));
        assertFalse(grid.isOn(12, 14));
    }

    @Test
    public void testTurnOn() throws Exception {
        Grid grid = new Grid();
        grid.turnOn(6, 6);
        assertTrue(grid.isOn(6, 6));
    }

    @Test
    public void testTurnOnSquare() throws Exception {
        Grid grid = new Grid();
        grid.turnOn(0, 0, 2, 2);
        assertFalse(grid.isOn(3, 3));
        assertTrue(grid.isOn(0, 0));
        assertTrue(grid.isOn(0, 1));
        assertTrue(grid.isOn(1, 0));
        assertTrue(grid.isOn(1, 1));
        assertTrue(grid.isOn(2, 0));
        assertTrue(grid.isOn(0, 2));
        assertTrue(grid.isOn(2, 2));
    }

    @Test
    public void testToggle() throws Exception {
        Grid grid = new Grid();
        grid.toggle(6, 6);
        assertTrue(grid.isOn(6, 6));
        grid.toggle(6, 6);
        assertFalse(grid.isOn(6, 6));
    }

    @Test
    public void testToggleOverriden() throws Exception {
        Grid grid = new Grid(true);
        grid.toggle(6, 6);
        assertTrue(grid.isOn(6, 6));
        grid.toggle(6, 6);
        assertTrue(grid.isOn(6, 6));
    }

    @Test
    public void testToggleSquare() throws Exception {
        Grid grid = new Grid();
        grid.turnOn(1, 1);
        grid.toggle(0, 0, 2, 2);
        assertFalse(grid.isOn(3, 3));
        assertTrue(grid.isOn(0, 0));
        assertTrue(grid.isOn(0, 1));
        assertTrue(grid.isOn(1, 0));
        assertFalse(grid.isOn(1, 1));
        assertTrue(grid.isOn(2, 0));
        assertTrue(grid.isOn(0, 2));
        assertTrue(grid.isOn(2, 2));
    }

    @Test
    public void testHowManyIsOn() throws Exception {
        Grid grid = new Grid();
        assertEquals(0, grid.howManyIsOn());
        grid.toggle(11, 11, 20, 20);
        assertEquals(100, grid.howManyIsOn());
    }

    @Test
    public void testTurnOff() throws Exception {
        Grid grid = new Grid();
        grid.turnOn(0, 0, 0, 10);
        assertTrue(grid.isOn(0, 5));
        grid.turnOff(0, 5);
        assertFalse(grid.isOn(0, 5));
        grid.turnOff(0, 0, 2, 2);
        assertFalse(grid.isOn(0, 0));
        assertFalse(grid.isOn(1, 0));
        assertFalse(grid.isOn(0, 1));
        assertFalse(grid.isOn(2, 0));
        assertTrue(grid.isOn(0, 3));
    }

    @Test
    public void testHandleCommand() throws Exception {
        Grid grid = new Grid();
        grid.handleCommand("turn on 10,10 through 20,20");
        assertEquals(121, grid.howManyIsOn());
    }

    @Test
    public void testBrightness() throws Exception {
        Grid grid = new Grid(true);
        grid.turnOn(0, 0, 0, 9);
        grid.toggle(1, 1, 2, 2);
        assertEquals(18, grid.brightness());
    }

    @Test
    public void testHowBrightIs() throws Exception {
        Grid grid = new Grid(true);
        grid.turnOn(1, 1);
        grid.toggle(1, 1);
        grid.toggle(1, 1);
        assertEquals(1 + 2 + 2, grid.howBrightIs(1, 1));
    }

    @Test
    public void testTwoMill() {
        Grid grid = new Grid(true);
        grid.toggle(0, 0, 999, 999);
        assertEquals(2000000, grid.brightness());
    }
}
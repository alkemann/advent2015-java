package com.alkemann.advent.nine;

import com.alkemann.advent.common.FileSolver;

public class Solver extends FileSolver {

    public static void main(String[] args) {
        Solver s = new Solver();
        s.readFile("src/main/resources/nine.txt");
        Travel t = new Travel(s.scanner);

        System.out.println("************************************");
        for (City c : t.cities.values()) {
            System.out.println(" Shortest from " + c.name + ": " + t.getShortestDistance(c.name));
        }
        System.out.println("************************************");

        System.out.println("************************************");
        for (City c : t.cities.values()) {
            System.out.println(" Longest from " + c.name + ": " + t.getLongestDistance(c.name));
        }
        System.out.println("************************************");
    }
}

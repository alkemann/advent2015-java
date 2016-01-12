package com.alkemann.advent.nine;

import com.alkemann.advent.common.FileSolver;

public class Solver extends FileSolver {

    public static void main(String[] args) {
        Solver s = new Solver();
        s.readFile("src/main/resources/nine.txt");
        Travel t = new Travel(s.scanner);
        System.out.println("************************************");
        System.out.println(" Shortest distane is : " + t.getShortestDistance("London"));
        System.out.println("************************************");
    }
}

package com.alkemann.advent.five;

import com.alkemann.advent.common.FileSolver;

public class Solver extends FileSolver{

    public static void main(String[] args) {
        Solver solver = new Solver();
        if (solver.readFile("src\\main\\resources\\five.txt")) {
//            solver.solveDayOne();
            solver.solveDayTwo();
        }
    }

    private void solveDayOne() {
        int counter = 0;
        String s;
        Present p;
        while (scanner.hasNext()) {
            s = scanner.next();
            p = new Present(s);
            if (p.isNice()) counter++;
        }
        scanner.close();
        System.out.println("===================");
        System.out.println(" Count: " + counter);
        System.out.println("===================");
    }

    private void solveDayTwo() {
        int counter = 0;
        String s;
        PresentTwo p;
        while (scanner.hasNext()) {
            s = scanner.next();
            p = new PresentTwo(s);
            if (p.isNice()) counter++;
        }
        scanner.close();
        System.out.println("===================");
        System.out.println(" Count: " + counter);
        System.out.println("===================");
    }
}

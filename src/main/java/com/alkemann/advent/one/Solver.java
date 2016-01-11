package com.alkemann.advent.one;

import com.alkemann.advent.common.FileSolver;

public class Solver extends FileSolver {

    boolean basementFound = false;
    int basement = 0;

    public int floor(String s) {
        int floor = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            floor += c == '(' ? 1 : -1;
            if (!basementFound) basement++;
            if (floor < 0) basementFound = true;
        }
        return floor;
    }

    private void solveFile() {
        String s = scanner.nextLine();
        System.out.println("Floor: " + floor(s));
        System.out.println("Basement at step: " + basement);
    }

    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.readFile("src\\main\\resources\\one.txt");
        solver.solveFile();
    }

}

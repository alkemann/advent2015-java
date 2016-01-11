package com.alkemann.advent.three;

import com.alkemann.advent.common.FileSolver;

import java.util.HashMap;

public class Solver extends FileSolver {

    HashMap<String, Integer> map;

    public void solve(String s) {
        map = new HashMap<>(10000);
        int x = 5000, y = 5000;
        map.put("5000,5000", 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '^': y++; break;
                case 'v': y--; break;
                case '<': x--; break;
                case '>': x++; break;
            }
            String pos = x+","+y;
            if (map.containsKey(pos)) map.put(pos, map.get(pos) + 1);
            else map.put(pos, 1);
        }
    }

    private void solveRobot(String s) {
        map = new HashMap<>(10000);
        int x = 5000, y = 5000, x2 = 5000, y2 = 5000;
        boolean robotTurn = false;
        map.put("5000,5000", 2);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '^': if(robotTurn) y2++; else y++; break;
                case 'v': if(robotTurn) y2--; else y--; break;
                case '<': if(robotTurn) x2--; else x--; break;
                case '>': if(robotTurn) x2++; else x++; break;
            }
            String pos = robotTurn ? x2+","+y2 : x+","+y;
            if (map.containsKey(pos)) map.put(pos, map.get(pos) + 1);
            else map.put(pos, 1);
            robotTurn = !robotTurn;
        }
    }

    public static void main(String[] args) {
        Solver s = new Solver();
        s.readFile("src\\main\\resources\\three.txt");
        String road = s.scanner.nextLine();
        s.solve(road);
        System.out.println("Houses: " + s.map.size());
        s.solveRobot(road);
        System.out.println("Houses with robot: " + s.map.size());
    }
}

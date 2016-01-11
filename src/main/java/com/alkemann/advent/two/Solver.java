package com.alkemann.advent.two;

import com.alkemann.advent.common.FileSolver;

public class Solver extends FileSolver {
    int area = 0, ribbon = 0;

    public void paper(String s) {
        String[] bits = s.split("x");
        int h = Integer.parseInt(bits[0]);
        int w = Integer.parseInt(bits[1]);
        int l = Integer.parseInt(bits[2]);
        int bow = h*l*w;

        if (h>=w && h>=l) {
            ribbon += w+w+l+l;
        } else if (w<l) {
            ribbon += h+h+w+w;
        } else {
            ribbon += h+h+l+l;
        }

        ribbon += bow;
        int smallest = w*l < w*h ? w*l : w*h;
        smallest = smallest < h*l ? smallest : h*l;
        area += smallest + (2*w*l) + (2*w*h) + (2*h*l);
    }

    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.readFile("src\\main\\resources\\two.txt");
        while (solver.scanner.hasNextLine()) {
            solver.paper(solver.scanner.nextLine());
        }
        System.out.println("Paper area: " + solver.area);
        System.out.println("Paper ribbon: " + solver.ribbon);
    }
}

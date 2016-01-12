package com.alkemann.advent.six;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solver {

    private final File file;

    public Solver() {
        file = new File("src/main/resources/six.txt");
    }

    // good: 377891
    public void howManyIsOn() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Grid grid = new Grid(false);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            grid.handleCommand(line);
        }
        System.out.println(" ++++++++++++++++++++++++ ");
        System.out.println("  Count:  " + grid.howManyIsOn());
        System.out.println(" ++++++++++++++++++++++++ ");
    }

    // bad : 1262027
    private void howBrightIsIt() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Grid grid = new Grid(true);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            grid.handleCommand(line);
        }
        System.out.println(" ++++++++++++++++++++++++ ");
        System.out.println("  Brightness:  " + grid.brightness());
        System.out.println(" ++++++++++++++++++++++++ ");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Solver s;
        try {
            s = new Solver();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        s.howManyIsOn();
        s.howBrightIsIt();
    }

}

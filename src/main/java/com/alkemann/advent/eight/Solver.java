package com.alkemann.advent.eight;

import com.alkemann.advent.common.FileSolver;

import java.util.ArrayList;
import java.util.List;

public class Solver extends FileSolver {

    Book book;

    public Solver(String filename) {
        this.readFile(filename);
        List<String> list = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        book = new Book(list);
    }

    public static void main(String[] args) {
        Solver solver = new Solver("src\\main\\resources\\eight.txt");
        System.out.println("************************************");
        System.out.println(" Extra character count: " + solver.book.howManyExtraCharacters());
        System.out.println("************************************");
    }
}

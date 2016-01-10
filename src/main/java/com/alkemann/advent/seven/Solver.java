package com.alkemann.advent.seven;

import com.alkemann.advent.common.FileSolver;
import com.alkemann.advent.seven.errors.UnknownGateTypeException;
import com.alkemann.advent.seven.gate.Set;

import java.util.ArrayList;
import java.util.List;

public class Solver extends FileSolver{

    public static void main(String[] args) throws UnknownGateTypeException {
        Solver solver = new Solver();
        solver.readFile("src\\main\\resources\\seven.txt");
        solver.solve();
    }

    private void solve() throws UnknownGateTypeException {
        List<String> commands = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            commands.add(scanner.nextLine());
        }

        Board board = new Board(commands);

        System.out.println("************************************");
        System.out.println(" Signal on wire 'a' : " + board.getWireSignal("a"));
        System.out.println("************************************");
    }
}

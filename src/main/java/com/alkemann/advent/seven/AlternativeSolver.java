package com.alkemann.advent.seven;

import com.alkemann.advent.common.FileSolver;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlternativeSolver extends FileSolver {

    private HashMap<String, Integer> wires = new HashMap<>();
    private HashMap<String, String> gates = new HashMap<>();

    private static final Pattern linePattern = Pattern.compile("(.*) -> (.*)");
    private static final Pattern notPattern = Pattern.compile("NOT ([\\d\\w]+)");
    private static final Pattern commandPattern = Pattern.compile("([\\d\\w]+) (AND|OR|LSHIFT|RSHIFT) ([\\d\\w]+)");

    public AlternativeSolver(String filename) {
        readFile(filename);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher match = linePattern.matcher(line);
            if (match.matches()) {
                wires.put(match.group(2), null);
                gates.put(match.group(2), match.group(1));
            }
        }
    }

    private int wire(String w) {
        if (wires.get(w) == null)
            wires.put(w, gate(w));
        return wires.get(w);
    }

    private int gate(String w) {
        String gateString = gates.get(w);

        try {
            return Integer.parseInt(gateString);
        } catch (NumberFormatException e) {}

        if (gateString.contains(" ") == false) return wire(gateString);

        Matcher mNot = notPattern.matcher(gateString);
        if (mNot.matches()) {
            try {
                return ~Integer.parseInt(mNot.group(1)) & 65535;
            } catch (NumberFormatException e) {}
            return ~wire(mNot.group(1)) & 65535;
        }

        Matcher m = commandPattern.matcher(gateString);
        if (m.matches()) {
            int a, b;
            try {
                a = Integer.parseInt(m.group(1));
            } catch (NumberFormatException e) {
                a = wire(m.group(1));
            }
            try {
                b = Integer.parseInt(m.group(3));
            } catch (NumberFormatException e) {
                b = wire(m.group(3));
            }
            switch (m.group(2)) {
                case "AND":     return a & b & 65535;
                case "OR":      return a | b & 65535;
                case "LSHIFT":  return a << b & 65535;
                case "RSHIFT":  return a >> b & 65535;
            }
        }
        return -1; // yea this should never happen
    }

    public static void main(String[] args) {
        AlternativeSolver solver = new AlternativeSolver("src\\main\\resources\\seven.txt");
        System.out.println("Wire [a]: " + solver.wire("a"));
    }

    @SuppressWarnings("unused")
    private static void test() {
        AlternativeSolver solver = new AlternativeSolver("src\\main\\resources\\seven_test.txt");
        System.out.println("Wire [x]: " + solver.wire("x"));
        System.out.println("Wire [f]: " + solver.wire("f"));
        System.out.println("Wire [g]: " + solver.wire("g"));
        System.out.println("Wire [h]: " + solver.wire("h"));
        System.out.println("Wire [e]: " + solver.wire("e"));
        System.out.println("Wire [i]: " + solver.wire("i"));
        System.out.println("Wire [d]: " + solver.wire("d"));
        System.out.println(solver.wires.entrySet());
    }
}

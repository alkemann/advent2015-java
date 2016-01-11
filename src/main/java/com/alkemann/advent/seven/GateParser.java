package com.alkemann.advent.seven;

import com.alkemann.advent.seven.errors.UnknownGateTypeException;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.alkemann.advent.seven.Gate.Type.*;

public class GateParser {

    final String description;
    final Gate.Type type;
    final String inputOne;
    final String inputTwo;
    final String output;

     HashMap<Gate.Type, Pattern> patterns = new HashMap<>(6);

    public GateParser(String description) {
        this.description = description;
        /*
        "456 -> y"
        "NOT x -> h"
        "x AND y -> d"
        "x OR y -> e"
        "x LSHIFT 2 -> f"
        "y RSHIFT 2 -> g"
        */
        patterns.put(SET,    Pattern.compile("^([\\d\\w]+) -> ([\\w]+)$"));
        patterns.put(NOT,    Pattern.compile("^NOT ([\\d\\w]+) -> ([\\w]+)$"));
        patterns.put(AND,    Pattern.compile("^([\\d\\w]+) AND ([\\d\\w]+) -> ([\\w]+)$"));
        patterns.put(OR,     Pattern.compile("^([\\d\\w]+) OR ([\\d\\w]+) -> ([\\w]+)$"));
        patterns.put(LSHIFT, Pattern.compile("^([\\d\\w]+) LSHIFT ([\\d\\w]+) -> ([\\w]+)$"));
        patterns.put(RSHIFT, Pattern.compile("^([\\d\\w]+) RSHIFT ([\\d\\w]+) -> ([\\w]+)$"));

        Gate.Type type = null;
        Matcher matcher = null;

        for (Entry<Gate.Type, Pattern> entry : patterns.entrySet()) {
            type = entry.getKey();
            Pattern pattern = entry.getValue();
            matcher = pattern.matcher(description);

            if (matcher.matches()) break;
        }

        if (type == null || matcher == null) throw new UnknownGateTypeException();

        try {
            switch (type) {
                case SET:
                    this.type = SET;
                    inputOne = matcher.group(1);
                    inputTwo = null;
                    output = matcher.group(2);
                    break;
                case NOT:
                    this.type = NOT;
                    inputOne = matcher.group(1);
                    inputTwo = null;
                    output = matcher.group(2);
                    break;
                case AND:
                    this.type = AND;
                    inputOne = matcher.group(1);
                    inputTwo = matcher.group(2);
                    output = matcher.group(3);
                    break;
                case OR:
                    this.type = OR;
                    inputOne = matcher.group(1);
                    inputTwo = matcher.group(2);
                    output = matcher.group(3);
                    break;
                case LSHIFT:
                    this.type = LSHIFT;
                    inputOne = matcher.group(1);
                    inputTwo = matcher.group(2);
                    output = matcher.group(3);
                    break;
                case RSHIFT:
                    this.type = RSHIFT;
                    inputOne = matcher.group(1);
                    inputTwo = matcher.group(2);
                    output = matcher.group(3);
                    break;
                default:
                    throw new UnknownGateTypeException();
            }
        } catch (IllegalStateException e) {
            System.out.println(description);
            System.out.println(matcher.toString());
            throw e;
        }
    }
}

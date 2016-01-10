package com.alkemann.advent.seven.gate;

import com.alkemann.advent.seven.Gate;
import com.alkemann.advent.seven.gate.types.SingleGate;

public class Set extends SingleGate {

    public Set(String inputOne, String output) {
        super(inputOne, output);
    }

    @Override
    public void run() {
        int out = inputOne.getValue() & Gate.MAX;
        output.set(out);
    }
}

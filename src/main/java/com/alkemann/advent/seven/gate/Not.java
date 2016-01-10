package com.alkemann.advent.seven.gate;

import com.alkemann.advent.seven.Gate;
import com.alkemann.advent.seven.gate.types.SingleGate;

public class Not extends SingleGate {

    public Not(String in, String output) {
        super(in, output);
    }

    @Override
    public void run() {
        int out = ~((int) inputOne.getValue()) & Gate.MAX;
        output.set(out);
    }
}

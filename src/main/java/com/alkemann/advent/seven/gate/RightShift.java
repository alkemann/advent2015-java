package com.alkemann.advent.seven.gate;

import com.alkemann.advent.seven.Gate;
import com.alkemann.advent.seven.gate.types.DoubleGate;

public class RightShift extends DoubleGate {

    public RightShift(String inputOne, String inputTwo, String output) {
        super(inputOne, inputTwo, output);
    }

    @Override
    public void run() {
        int out = (inputOne.getValue() >> (int) inputTwo.getValue()) & Gate.MAX;
        output.set(out);
    }
}

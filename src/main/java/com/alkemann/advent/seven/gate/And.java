package com.alkemann.advent.seven.gate;

import com.alkemann.advent.seven.Gate;
import com.alkemann.advent.seven.gate.types.DoubleGate;

public class And extends DoubleGate {

    public And(String inputOne, String inputTwo, String output) {
        super(inputOne, inputTwo, output);
    }

    @Override
    public void run() {
        output.set((inputOne.getValue() & inputTwo.getValue()) & Gate.MAX);
    }
}

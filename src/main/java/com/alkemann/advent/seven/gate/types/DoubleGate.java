package com.alkemann.advent.seven.gate.types;

import com.alkemann.advent.seven.Gate;
import com.alkemann.advent.seven.listeners.GateInputChanged;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class DoubleGate extends Gate {

    protected IntegerProperty inputOne = new SimpleIntegerProperty(-1);
    protected IntegerProperty inputTwo = new SimpleIntegerProperty(-1);

    public DoubleGate(String inOne, String inTwo, String out) {
        inputOneAddress = inOne;
        inputTwoAddress = inTwo;
        outputAddress = out;
        inputOne.addListener(new GateInputChanged(this));
        inputTwo.addListener(new GateInputChanged(this));
        try {
            int value = Integer.parseInt(inOne);
            inputOne.setValue(value);
            inputOneAddress = null;
        } catch (NumberFormatException e) {
            // We only know address, not value
        }
        try {
            int value = Integer.parseInt(inTwo);
            inputTwo.setValue(value);
            inputTwoAddress = null;
        } catch (NumberFormatException e) {
            // We only know address, not value
        }
    }

    @Override
    public void inputsChanged()  {
        if (inputTwo.getValue() == -1) return;
        if (inputOne.getValue() == -1) return;
//        System.out.println("Ready to go with [" + inputOne.getValue() + "] and [" + inputTwo.getValue() + "]");
        run();
    }

    public IntegerProperty inputOneProperty() {
        return inputOne;
    }

    public int getInputOne() {
        return inputOne.get();
    }

    public void setInputOne(int inputOne) {
        this.inputOne.set(inputOne);
    }

    public IntegerProperty inputTwoProperty() {
        return inputTwo;
    }

    public int getInputTwo() {
        return inputTwo.get();
    }

    public void setInputTwo(int inputTwo) {
        this.inputTwo.set(inputTwo);
    }

    public String getInputOneAddress() {
        return inputOneAddress;
    }

    public String getInputTwoAddress() {
        return inputTwoAddress;
    }
}

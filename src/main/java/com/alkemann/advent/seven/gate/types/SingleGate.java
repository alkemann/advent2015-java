package com.alkemann.advent.seven.gate.types;

import com.alkemann.advent.seven.Gate;
import com.alkemann.advent.seven.listeners.GateInputChanged;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

@SuppressWarnings("unused")
public abstract class SingleGate extends Gate {
    protected IntegerProperty inputOne = new SimpleIntegerProperty(-1);

    public SingleGate(String input, String output) {
        outputAddress = output;
        inputOneAddress = input;
        inputOne.addListener(new GateInputChanged(this));
        try {
            int value = Integer.parseInt(input);
            inputOne.setValue(value);
            inputOneAddress = null;
        } catch (NumberFormatException e) {
            // we do not know value, only address
        }
    }

    @Override
    public void inputsChanged() {
        if (inputOne.getValue() == -1) return;
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

    public String getInputOneAddress() {
        return inputOneAddress;
    }
}

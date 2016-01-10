package com.alkemann.advent.seven.listeners;

import com.alkemann.advent.seven.Gate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class GateInputChanged implements ChangeListener {

    private Gate gate;

    public GateInputChanged(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        IntegerProperty property = (IntegerProperty) observable;
        int val = property.getValue();
        if (val < 0 || val > Gate.MAX) {
            System.out.println("Value out of bounds: ["+val+"]");
            System.exit(-1);
        }
        gate.inputsChanged();
    }
}

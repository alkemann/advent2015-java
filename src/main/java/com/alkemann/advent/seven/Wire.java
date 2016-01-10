package com.alkemann.advent.seven;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

@SuppressWarnings("unused")
public class Wire {

    final String name;
    protected IntegerProperty value = new SimpleIntegerProperty(-1);

    public Wire(String name) {
        this.name = name;
    }

    public IntegerProperty valueProperty() {
        return value;
    }

    public int getValue() {
        return value.get();
    }

    public void setValue(int value) {
        this.value.set(value);
    }
}

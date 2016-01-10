package com.alkemann.advent.seven;

import com.alkemann.advent.seven.errors.UnknownGateTypeException;
import com.alkemann.advent.seven.gate.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

@SuppressWarnings("unused")
public abstract class Gate {

    public enum Type {SET, NOT, AND, OR, LSHIFT, RSHIFT};

    public static final int MAX = 65535;

    protected String inputOneAddress = null;
    protected String inputTwoAddress = null;
    protected String outputAddress = null;
    protected IntegerProperty output = new SimpleIntegerProperty(-1);

    public abstract void run();

    public abstract void inputsChanged();

    public IntegerProperty outputProperty() {
        return output;
    }

    public int getOutput() {
        return output.get();
    }

    public void setOutput(int output) {
        this.output.set(output);
    }

    public static Gate createFromString(String description) throws UnknownGateTypeException {
        GateParser parser = new GateParser(description);
        switch (parser.type) {
            case SET:
                return new Set(parser.inputOne, parser.output);
            case NOT:
                return new Not(parser.inputOne, parser.output);
            case AND:
                return new And(parser.inputOne, parser.inputTwo, parser.output);
            case OR:
                return new Or(parser.inputOne, parser.inputTwo, parser.output);
            case LSHIFT:
                return new LeftShift(parser.inputOne, parser.inputTwo, parser.output);
            case RSHIFT:
                return new RightShift(parser.inputOne, parser.inputTwo, parser.output);
        }
        return null;
    }
}

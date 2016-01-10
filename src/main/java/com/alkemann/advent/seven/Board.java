package com.alkemann.advent.seven;

import com.alkemann.advent.seven.errors.UnknownGateTypeException;
import com.alkemann.advent.seven.gate.Set;
import com.alkemann.advent.seven.gate.types.DoubleGate;
import com.alkemann.advent.seven.gate.types.SingleGate;
import javafx.beans.property.IntegerProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Board {

    HashMap<String, Gate> board;

    public Board(List<String> commands) throws UnknownGateTypeException {
        board = new HashMap<>(commands.size());

        for(String s : commands) {
            Gate g = Gate.createFromString(s);
            board.put(g.outputAddress, g);
        }
        for(Entry<String, Gate> e : board.entrySet()) {
            Gate g = e.getValue();
            if (g instanceof SingleGate) {
                SingleGate sg = (SingleGate) g;
                if (sg.getInputOneAddress() != null) {
                    sg.inputOneProperty().bind(board.get(sg.getInputOneAddress()).outputProperty());
                }
            } else if (g instanceof DoubleGate) {
                DoubleGate dg = (DoubleGate) g;
                if (dg.getInputOneAddress() != null) {
                    dg.inputOneProperty().bind(board.get(dg.getInputOneAddress()).outputProperty());
                }
                if (dg.getInputTwoAddress() != null) {
                    Gate from = board.get(dg.getInputTwoAddress());
                    IntegerProperty prop = from.outputProperty();
                    dg.inputTwoProperty().bind(prop);
                }
            } else {
                throw new RuntimeException("What kind of gate is this?");
            }
        }
    }

    public int getWireSignal(String outputWireAddress) {
        return board.get(outputWireAddress).getOutput();
    }

    public void addGate(Set gate) {
        board.put(gate.outputAddress, gate);
    }
}

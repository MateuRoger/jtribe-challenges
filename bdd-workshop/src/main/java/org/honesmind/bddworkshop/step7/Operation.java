package org.honesmind.bddworkshop.step7;

import java.util.Arrays;

public enum Operation {
    ADD('+');

    private final char op;

    Operation(final char op) {
        this.op = op;
    }

    public char getOp() {
        return op;
    }

    public static Operation getOperationByValue(final char op){
        return Arrays.stream(Operation.values())
            .filter(operation -> operation.getOp() == op)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Not exists the given operation"));
    }
}

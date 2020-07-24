package org.honesmind.bddworkshop.step7;

public class CalculatorServiceImpl implements CalculatorService {

    public int execute(final int x, final int y, final char op) {
        if (Operation.getOperationByValue(op) == Operation.ADD) {
            return x + y;
        } else {
            return -1;
        }
    }
}

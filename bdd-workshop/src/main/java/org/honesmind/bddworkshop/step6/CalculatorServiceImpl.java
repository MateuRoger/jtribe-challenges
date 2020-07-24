package org.honesmind.bddworkshop.step6;

public class CalculatorServiceImpl implements CalculatorService {

    public int execute(final int x, final int y, final char op) {
        if (op == '+') {
            return x + y;
        } else {
            return -1;
        }
    }
}

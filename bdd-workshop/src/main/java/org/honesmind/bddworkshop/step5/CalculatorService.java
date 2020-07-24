package org.honesmind.bddworkshop.step5;

public class CalculatorService {

    public int execute(final int x, final int y, final char op) {
        if (op == '+') {
            return x + y;
        } else {
            return -1;
        }
    }
}

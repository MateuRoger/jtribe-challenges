package service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import service.EightQueensCalculator;

class EightQueensCalculatorImplTest {

  @Test
  void eightQueens() {
    String[] eightQueensMap = new String[] {"(2,1)", "(4,3)", "(6,3)", "(8,4)", "(3,4)", "(1,6)",
        "(7,7)", "(5,8)"};

    EightQueensCalculator eightQueensCalculator = new EightQueensCalculatorImpl();

    String result = eightQueensCalculator.eightQueens(eightQueensMap);

    assertEquals("(2,1)", result);
  }
}
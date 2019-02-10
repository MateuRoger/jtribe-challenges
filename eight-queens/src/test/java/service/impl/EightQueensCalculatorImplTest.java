package service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import errors.exception.CoordinateException;
import org.junit.jupiter.api.Test;
import service.EightQueensCalculator;

class EightQueensCalculatorImplTest {

  @Test
  void eightQueens1() throws CoordinateException {
    String[] eightQueensMap = new String[] {"(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)",
        "(7,7)", "(5,8)"};

    EightQueensCalculator eightQueensCalculator = new EightQueensCalculatorImpl();

    String result = eightQueensCalculator.eightQueens(eightQueensMap);

    assertEquals(Boolean.TRUE.toString(), result);
  }

  @Test
  void eightQueens2() throws CoordinateException {
    String[] eightQueensMap = new String[] {"(2,1)", "(4,3)", "(6,3)", "(8,4)", "(3,4)", "(1,6)",
        "(7,7)", "(5,8)"};

    EightQueensCalculator eightQueensCalculator = new EightQueensCalculatorImpl();

    String result = eightQueensCalculator.eightQueens(eightQueensMap);

    assertEquals("(2,1)", result);
  }

  @Test
  void eightQueens3() throws CoordinateException {
    String[] eightQueensMap = new String[] {"(2,1)", "(5,3)", "(6,3)", "(8,4)", "(3,4)", "(1,8)",
        "(7,7)", "(5,8)"};

    EightQueensCalculator eightQueensCalculator = new EightQueensCalculatorImpl();

    String result = eightQueensCalculator.eightQueens(eightQueensMap);

    assertEquals("(5,3)", result);
  }

  @Test
  void eightQueens4() throws CoordinateException {
    String[] eightQueensMap = new String[] {"(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)",
        "(7,7)", "(7,8)"};

    EightQueensCalculator eightQueensCalculator = new EightQueensCalculatorImpl();

    String result = eightQueensCalculator.eightQueens(eightQueensMap);

    assertEquals("(7,7)", result);
  }

}
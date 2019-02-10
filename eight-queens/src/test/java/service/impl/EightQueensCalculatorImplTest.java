package service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import errors.exception.CoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import service.EightQueensCalculator;

class EightQueensCalculatorImplTest {


  @ParameterizedTest
  @ArgumentsSource(EightQueensScenariosArgumentProvider.class)
  @DisplayName("Test to the Eight Queens Calculator with different scenarios")
  void eightQueensCalculatorWithDifferntScenarios(String[] scenario,
      String expectedResult)
      throws CoordinateException {
    EightQueensCalculator eightQueensCalculator = new EightQueensCalculatorImpl();

    String result = eightQueensCalculator.eightQueens(scenario);

    assertEquals(expectedResult, result);
  }

  @Test
  @DisplayName("A scenario with an incorrect coordinate should send an exception")
  void scenarioWithIncorrectCoordinateThorwsAnException() {
    String[] scenario = new String[] {"(2,1)", "(4,2)", "(6,3)", "(-8,4)", "(3,5)", "(1,6)",
        "(7,7)", "(5,8)"};
    EightQueensCalculator eightQueensCalculator = new EightQueensCalculatorImpl();

    assertThrows(CoordinateException.class, () -> eightQueensCalculator.eightQueens(scenario));
  }

}
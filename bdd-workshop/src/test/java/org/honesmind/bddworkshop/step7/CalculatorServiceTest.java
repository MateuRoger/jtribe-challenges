package org.honesmind.bddworkshop.step7;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    @Test
    void addTest() {
        final CalculatorService calculatorService = new CalculatorServiceImpl();
        assertThat(calculatorService.execute(2, 2, '+')).isEqualTo(4);
    }
}

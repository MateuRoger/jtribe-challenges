package org.honesmind.bddworkshop.step6;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.jupiter.api.Test;

public class AddOperationTest {

    @Test
    void addTest() {
        assertThat(AddOperation.add(2, 2)).isEqualTo(4);
    }
}

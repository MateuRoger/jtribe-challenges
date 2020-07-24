package org.honesmind.bddworkshop.step1;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.jupiter.api.Test;

public class AddOperationTest {

    @Test
    void addTest() {
        final AddOperation addOperation = new AddOperation();
        int result = addOperation.add(2, 2);

        assertThat(result).isEqualTo(4);
    }
}

package service.builder;

import org.junit.jupiter.api.Test;
import service.builder.exception.ClosestEnemyIIBuilderException;

class ClosestEnemyIIBuilderTest {

  @Test
  public void build3x3With1Enemy() throws ClosestEnemyIIBuilderException {
    new ClosestEnemyIIBuilderImpl().createsWarMap(3, 0, 0);
  }
}
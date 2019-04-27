package service.builder;

import service.builder.exception.ClosestEnemyIIBuilderException;
import service.builder.validations.ConsistenceWarMapParameters;

public interface ClosestEnemyIIBuilder {

  @ConsistenceWarMapParameters
  String[] createsWarMap(int dimension, int enemyNumber, int distance)
      throws ClosestEnemyIIBuilderException;
}

package service.builder;

import javax.validation.constraints.Min;
import service.builder.exception.ClosestEnemyIIBuilderException;
import service.builder.validations.ConsistenceWarMapParameters;

public class ClosestEnemyIIBuilderImpl implements ClosestEnemyIIBuilder {

  @ConsistenceWarMapParameters
  @Override
  public String[] createsWarMap(@Min(2) int dimension, @Min(1) int enemyNumber,
      @Min(1) int distance)
      throws ClosestEnemyIIBuilderException {

    String[] warMap = new String[dimension];

    int intialCordX = (int) (Math.random() % dimension);

    return warMap;
  }
}

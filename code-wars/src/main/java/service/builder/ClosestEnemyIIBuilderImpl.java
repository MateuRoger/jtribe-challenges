package service.builder;

import entity.Coordinate;
import entity.WarMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.validation.constraints.Min;
import service.builder.exception.ClosestEnemyIIBuilderException;
import service.builder.validations.ConsistenceWarMapParameters;

public class ClosestEnemyIIBuilderImpl implements ClosestEnemyIIBuilder {

  private final List<Coordinate> enemyCoordsList = new ArrayList<>();
  private Coordinate initialCoord = new Coordinate();

  @ConsistenceWarMapParameters
  @Override
  public String[] createsWarMap(@Min(2) int dimension, @Min(1) int enemyNumber,
      @Min(1) int distance)
      throws ClosestEnemyIIBuilderException {

    final WarMap warMap = new WarMap(new String[dimension]);
    this.initialCoord = new Coordinate().setCoordinateX((int) (Math.random() % dimension));
    warMap.setCoordinate(this.initialCoord, '1');

    int direction = ThreadLocalRandom.current().nextInt(0, 8);

    return warMap.getWarMapStr();
  }
}

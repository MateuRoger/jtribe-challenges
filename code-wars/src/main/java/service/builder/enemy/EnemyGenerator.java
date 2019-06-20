package service.builder.enemy;

import entity.Coordinate;
import entity.WarMap;
import service.builder.enemy.generator.EnemyBuilderEnum;

public class EnemyGenerator {

  public Coordinate generateEnemy(final Coordinate initialCoord, final int distance,
      final WarMap warMap) {
    Coordinate enemyCoordinate;
    final EnemyBuilderEnum initialEnemy = EnemyBuilderEnum.UP;
    EnemyBuilderEnum currentEnemy = initialEnemy;

    do {
      enemyCoordinate = currentEnemy.build(initialCoord, distance, warMap);
      if (warMap.getValueOfCoord(enemyCoordinate) != '2') {
        warMap.setCoordinate(enemyCoordinate, '2');
        break;
      } else {
        currentEnemy = currentEnemy.next();
      }

    } while (initialEnemy != currentEnemy);

    return enemyCoordinate;
  }
}

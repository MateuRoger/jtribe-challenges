package service.impl;

import entity.Coordinate;
import entity.WarMap;
import java.util.HashMap;
import java.util.Map;
import service.ClosestEnemyII;

public class ClosestEnemyIIByRecursiveMethod implements ClosestEnemyII {

  private static final char INITIAL_VALUE = '1';
  private static final char ENEMY_VALUE = '2';
  private Map<Coordinate, Character> scannedMap = new HashMap<>();


  @Override
  public int whitchEnemyIsClosest(String[] warMapString) {

    final WarMap warMap = new WarMap().setWarMapStr(warMapString);
    final Coordinate maxCoordinate = warMap.getMaxCoord();

    Coordinate actualCoordinate = new Coordinate()
        .setCoordinateX(maxCoordinate.getCoordinateX() / 2)
        .setCoordinateY(maxCoordinate.getCoordinateY() / 2);

    Coordinate initialCoordinate = searchInitialCoord(warMap, actualCoordinate);

    scannedMap.clear();
    Coordinate closeseEnemyCoordinate = getClosestEnemyCoordinate(warMap, initialCoordinate);

    return Math.min(
        (Math.max(initialCoordinate.getCoordinateX(), closeseEnemyCoordinate.getCoordinateX())
            - Math
            .min(initialCoordinate.getCoordinateX(), closeseEnemyCoordinate.getCoordinateX())),
        (warMapString[0].length() - closeseEnemyCoordinate.getCoordinateX() + initialCoordinate
            .getCoordinateX())
    )
        + Math.min(
        (Math.max(initialCoordinate.getCoordinateY(), closeseEnemyCoordinate.getCoordinateY())
            - Math
            .min(initialCoordinate.getCoordinateY(), closeseEnemyCoordinate.getCoordinateY())),
        (warMapString.length - closeseEnemyCoordinate.getCoordinateY() + initialCoordinate
            .getCoordinateY())
    );
  }

  private Coordinate searchInitialCoord(final WarMap warMap, final Coordinate actualCoordinate) {
    Coordinate coordinate = new Coordinate();
    scannedMap.put(actualCoordinate, warMap.getValueOfCoord(actualCoordinate));

    if (warMap.getValueOfCoord(actualCoordinate) == INITIAL_VALUE) {
      coordinate = actualCoordinate;
    } else {
      if (!scannedMap.containsKey(warMap.getUpCoordinate(actualCoordinate))) {
        coordinate = searchInitialCoord(warMap, warMap.getUpCoordinate(actualCoordinate));
      }

      if (coordinate.isEmpty() && !scannedMap
          .containsKey(warMap.getRightCoordinate(actualCoordinate))) {
        coordinate = searchInitialCoord(warMap, warMap.getRightCoordinate(actualCoordinate));
      }
      if (coordinate.isEmpty() && !scannedMap
          .containsKey(warMap.getDownCoordinate(actualCoordinate))) {
        coordinate = searchInitialCoord(warMap, warMap.getDownCoordinate(actualCoordinate));
      }
      if (coordinate.isEmpty() && !scannedMap
          .containsKey(warMap.getLeftCoordinate(actualCoordinate))) {
        coordinate = searchInitialCoord(warMap, warMap.getLeftCoordinate(actualCoordinate));
      }
    }

    return coordinate;
  }

  private Coordinate getClosestEnemyCoordinate(final WarMap warMap,
      final Coordinate actualCoordinate) {
    Coordinate coordinate = new Coordinate();
    scannedMap.put(actualCoordinate, warMap.getValueOfCoord(actualCoordinate));

    if (warMap.getValueOfCoord(actualCoordinate) == ENEMY_VALUE) {
      coordinate = actualCoordinate;
    } else {
      if (!scannedMap.containsKey(warMap.getUpCoordinate(actualCoordinate))) {
        coordinate = getClosestEnemyCoordinate(warMap, warMap.getUpCoordinate(actualCoordinate));
      }

      if (coordinate.isEmpty() && !scannedMap
          .containsKey(warMap.getRightCoordinate(actualCoordinate))) {
        coordinate = getClosestEnemyCoordinate(warMap, warMap.getRightCoordinate(actualCoordinate));
      }
      if (coordinate.isEmpty() && !scannedMap
          .containsKey(warMap.getDownCoordinate(actualCoordinate))) {
        coordinate = getClosestEnemyCoordinate(warMap, warMap.getDownCoordinate(actualCoordinate));
      }
      if (coordinate.isEmpty() && !scannedMap
          .containsKey(warMap.getLeftCoordinate(actualCoordinate))) {
        coordinate = getClosestEnemyCoordinate(warMap, warMap.getLeftCoordinate(actualCoordinate));
      }
    }

    return coordinate;
  }

}

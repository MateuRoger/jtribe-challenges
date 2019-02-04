package service.impl;

import entity.Coordinate;
import entity.WarMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.ClosestEnemyII;

public class ClosestEnemyIIByRecursiveMethod implements ClosestEnemyII {

  private static final char INITIAL_VALUE = '1';
  private static final char ENEMY_VALUE = '2';
  private Map<Coordinate, Character> scannedMap = new HashMap<>();
  private List<Coordinate> enemyList = new ArrayList<>();


  @Override
  public int whitchEnemyIsClosest(String[] warMapString) {
    int distance = 0;

    final WarMap warMap = new WarMap().setWarMapStr(warMapString);
    final Coordinate maxCoordinate = warMap.getMaxCoord();

    Coordinate actualCoordinate = new Coordinate()
      .setCoordinateX(maxCoordinate.getCoordinateX() / 2)
      .setCoordinateY(maxCoordinate.getCoordinateY() / 2);

    Coordinate initialCoordinate = searchInitialCoord(warMap, actualCoordinate);

    getClosestEnemyCoordinate(warMap, actualCoordinate, distance);

    return distance;
  }

  private Coordinate searchInitialCoord(final WarMap warMap, final Coordinate actualCoordinate) {
    Coordinate coordinate = new Coordinate();

    if ( warMap.getValueOfCoord(actualCoordinate) == INITIAL_VALUE){
      coordinate = actualCoordinate;
    }else{
      if(warMap.isCoordIsWithinMap(actualCoordinate.getUpCoordinate())) {
        coordinate = searchInitialCoord(warMap, actualCoordinate.getUpCoordinate());
      }
      if(coordinate.isEmpty() && warMap.isCoordIsWithinMap(actualCoordinate.getRightCoordinate())) {
        coordinate = searchInitialCoord(warMap, actualCoordinate.getRightCoordinate());
      }
      if(coordinate.isEmpty() && warMap.isCoordIsWithinMap(actualCoordinate.getDownCoordinate())) {
        coordinate = searchInitialCoord(warMap, actualCoordinate.getDownCoordinate());
      }
      if(coordinate.isEmpty() &&warMap.isCoordIsWithinMap(actualCoordinate.getLeftCoordinate())) {
        coordinate = searchInitialCoord(warMap, actualCoordinate.getLeftCoordinate());
      }
    }

    return coordinate;
  }

  private Coordinate getClosestEnemyCoordinate(final WarMap warMap, final Coordinate actualCoordinate, int distance) {
    Coordinate coordinate = new Coordinate();

    if ( warMap.getValueOfCoord(actualCoordinate) == ENEMY_VALUE){
      coordinate = actualCoordinate;
    }else{
      if(warMap.isCoordIsWithinMap(actualCoordinate.getUpCoordinate())) {
        coordinate = searchInitialCoord(warMap, actualCoordinate.getUpCoordinate());
      }
      if(coordinate.isEmpty() && warMap.isCoordIsWithinMap(actualCoordinate.getRightCoordinate())) {
        coordinate = searchInitialCoord(warMap, actualCoordinate.getRightCoordinate());
      }
      if(coordinate.isEmpty() && warMap.isCoordIsWithinMap(actualCoordinate.getDownCoordinate())) {
        coordinate = searchInitialCoord(warMap, actualCoordinate.getDownCoordinate());
      }
      if(coordinate.isEmpty() &&warMap.isCoordIsWithinMap(actualCoordinate.getLeftCoordinate())) {
        coordinate = searchInitialCoord(warMap, actualCoordinate.getLeftCoordinate());
      }
    }

    return coordinate;
  }

}

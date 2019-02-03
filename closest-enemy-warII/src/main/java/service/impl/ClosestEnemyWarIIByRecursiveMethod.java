package service.impl;

import entity.Coordinate;
import entity.WarMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.ClosestEnemyWarII;

public class ClosestEnemyWarIIByRecursiveMethod implements ClosestEnemyWarII {

  private static final char INITIAL_VALUE = '1';
  private static final char ENEMY_VALUE = '2';
  private Map<Coordinate, Character> scannedMap = new HashMap<>();
  private List<Coordinate> enemyList = new ArrayList<>();
  private Coordinate maxCoordinate;
  private Coordinate initialCoordinate;


  @Override
  public int whitchEnemyIsClosest(String[] warMapString) {
    int distance = 0;

    WarMap warMap = new WarMap().setWarMapStr(warMapString);
    maxCoordinate = warMap.getMaxCoord();

    Coordinate actualCoordinate = new Coordinate()
      .setCoordinateX(maxCoordinate.getCoordinateX() / 2)
      .setCoordinateY(maxCoordinate.getCoordinateY() / 2);

    char elementToSearch = INITIAL_VALUE;

    searchInitialCoord(warMap, actualCoordinate, elementToSearch);

    return distance;
  }

  private void searchInitialCoord(final WarMap warMap, final Coordinate actualCoordinate, final char elementToSearch) {
    if ( warMap.getValueOfCoord(actualCoordinate) == elementToSearch){
      initialCoordinate = actualCoordinate;
      scannedMap.put(actualCoordinate, elementToSearch);
    }else{
      Coordinate coordinateUp = new Coordinate()
          .setCoordinateX(actualCoordinate.getCoordinateX())
          .setCoordinateY(actualCoordinate.getCoordinateY() + 1);
      Coordinate coordinateRight = new Coordinate()
          .setCoordinateX(actualCoordinate.getCoordinateX() + 1)
          .setCoordinateY(actualCoordinate.getCoordinateY());
      Coordinate coordinateDown = new Coordinate()
          .setCoordinateX(actualCoordinate.getCoordinateX())
          .setCoordinateY(actualCoordinate.getCoordinateY() - 1);
      Coordinate coordinateLeft = new Coordinate()
          .setCoordinateX(actualCoordinate.getCoordinateX() - 1)
          .setCoordinateY(actualCoordinate.getCoordinateY());

      if( warMap.)

    }
  }
}

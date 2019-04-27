package service.solver.impl;

import java.util.HashMap;
import java.util.Map;
import service.solver.ClosestEnemyIISolver;

public class ClosestEnemyIISolverByIterationPlusCalculation implements ClosestEnemyIISolver {


  @Override
  public int solve(String[] warMap) {
    int maxX = warMap[0].length();
    int maxY = warMap.length;

    int startPossitionX = 0;
    int startPossitionY = 0;

    Map<Integer, Integer> enemyPosition = new HashMap<>();

    int indexOfStart;
    int indexOfEnemies;

    for (int i = 0; warMap.length > i; i++) {
      indexOfStart = warMap[i].indexOf('1');
      if (indexOfStart >= 0) {
        startPossitionX = indexOfStart;
        startPossitionY = i;
      }

      indexOfEnemies = warMap[i].indexOf('2');
      if (indexOfEnemies >= 0) {
        enemyPosition.put(indexOfEnemies, i);
      }
    }

    int enemyX;
    int mindistanceXNormalCase;
    int mindistanceXCornerCase;
    int mindistanceY;
    int enemyY;
    int mindistanceYNormalCase;
    int mindistanceYCornerCase;
    int mindistanceX;
    Integer distance = null;

    for (Integer enemy : enemyPosition.keySet()) {
      enemyX = enemy;
      mindistanceXNormalCase =
          startPossitionX > enemyX ? startPossitionX - enemyX : enemyX - startPossitionX;
      mindistanceXCornerCase = maxX - enemyX + startPossitionX;

      mindistanceX = Math.min(mindistanceXNormalCase, mindistanceXCornerCase);

      enemyY = enemyPosition.get(enemy);
      mindistanceYNormalCase =
          startPossitionY > enemyY ? startPossitionY - enemyY : enemyY - startPossitionY;
      mindistanceYCornerCase = maxY - enemyY + startPossitionY;

      mindistanceY = Math.min(mindistanceYNormalCase, mindistanceYCornerCase);
      if (distance == null) {
        distance = mindistanceX + mindistanceY;
      }
      if (distance > mindistanceX + mindistanceY) {
        distance = mindistanceX + mindistanceY;
      }
    }

    return distance;
  }
}

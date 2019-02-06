package service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import service.ClosestEnemyII;

public class ClosestEnemyIIByIterationPlusCalculationTest {
  @Test
  public void the_enemy_is_1_down_closest(){
    String[] warMap = new String[] {"000", "010", "020"};

    ClosestEnemyII closestEnemyII = new ClosestEnemyIIByIterationPlusCalculation();
    assertEquals(1, closestEnemyII.whitchEnemyIsClosest(warMap));
  }

  @Test
  public void the_enemy_is_2_down_closest(){
    String[] warMap = new String[] {"0000", "0100", "0000", "0200"};

    ClosestEnemyII closestEnemyII = new ClosestEnemyIIByIterationPlusCalculation();
    assertEquals(2, closestEnemyII.whitchEnemyIsClosest(warMap));
  }

  @Test
  public void the_enemy_is_2_down_closest_with_more_than_1_enemy(){
    String[] warMap = new String[] {"0000", "0100", "0000", "0202"};

    ClosestEnemyII closestEnemyII = new ClosestEnemyIIByIterationPlusCalculation();
    assertEquals(2, closestEnemyII.whitchEnemyIsClosest(warMap));
  }

  @Test
  public void the_enemy_is_1_left_closest_with_corner_case(){
    String[] warMap = new String[] {"0000", "0100", "0000", "0002"};

    ClosestEnemyII closestEnemyII = new ClosestEnemyIIByIterationPlusCalculation();
    assertEquals(4, closestEnemyII.whitchEnemyIsClosest(warMap));
  }

  @Test
  public void total_corner_case(){
    String[] warMap = new String[] {"1000", "0000", "0000", "0002"};

    ClosestEnemyII closestEnemyII = new ClosestEnemyIIByIterationPlusCalculation();
    assertEquals(2, closestEnemyII.whitchEnemyIsClosest(warMap));
  }
}
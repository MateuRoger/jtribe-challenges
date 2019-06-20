package service.solver;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import service.solver.impl.ClosestEnemyIISolverByIterationPlusCalculation;

class ClosestEnemyIIByIterationPlusCalculationTest {

  @Test
  void the_enemy_is_1_down_closest() {
    String[] warMap = new String[] {"000", "010", "020"};

    ClosestEnemyIISolver closestEnemyIISolver = new ClosestEnemyIISolverByIterationPlusCalculation();
    assertEquals(1, closestEnemyIISolver.solve(warMap));
  }

  @Test
  void the_enemy_is_2_down_closest() {
    String[] warMap = new String[] {"0000", "0100", "0000", "0200"};

    ClosestEnemyIISolver closestEnemyIISolver = new ClosestEnemyIISolverByIterationPlusCalculation();
    assertEquals(2, closestEnemyIISolver.solve(warMap));
  }

  @Test
  void the_enemy_is_2_down_closest_with_more_than_1_enemy() {
    String[] warMap = new String[] {"0000", "0100", "0000", "0202"};

    ClosestEnemyIISolver closestEnemyIISolver = new ClosestEnemyIISolverByIterationPlusCalculation();
    assertEquals(2, closestEnemyIISolver.solve(warMap));
  }

  @Test
  void the_enemy_is_1_left_closest_with_corner_case() {
    String[] warMap = new String[] {"0000", "0100", "0000", "0002"};

    ClosestEnemyIISolver closestEnemyIISolver = new ClosestEnemyIISolverByIterationPlusCalculation();
    assertEquals(4, closestEnemyIISolver.solve(warMap));
  }

  @Test
  void total_corner_case() {
    String[] warMap = new String[] {"1000", "0000", "0000", "0002"};

    ClosestEnemyIISolver closestEnemyIISolver = new ClosestEnemyIISolverByIterationPlusCalculation();
    assertEquals(2, closestEnemyIISolver.solve(warMap));
  }
}
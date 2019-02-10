package service.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import service.EightQueensCalculator;

public class EightQueensCalculatorImpl implements EightQueensCalculator {

  @Override
  public String eightQueens(final String[] strArr) {
    String position;
    Queue<String> queenQueue = new LinkedList<>(Arrays.asList(strArr));

  }

  private String checkQueens(final String queen, Queue<String> queenQueue) {
    String position;
    if (queenQueue.isEmpty()) {
      position = Boolean.TRUE.toString();
    } else {
      position = checkQueen(queen, queenQueue);
    }
    return position;
  }

  private String checkQueen(final String queen, final Queue<String> queenQueue) {
    String position;

    if (queenQueue.isEmpty()) {
      position = Boolean.TRUE.toString();
    } else {
      String currentQueen = queenQueue.poll();
      if (mayQueenAttack(queen, currentQueen)) {
        position = queen;
      } else {
        position = checkQueen(currentQueen, queenQueue);
      }
    }
    return position;

  }
}

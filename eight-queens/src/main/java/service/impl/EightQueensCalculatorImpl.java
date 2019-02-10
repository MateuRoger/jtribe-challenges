package service.impl;

import entity.Coordinate;
import errors.exception.CoordinateException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import service.EightQueensCalculator;

public class EightQueensCalculatorImpl implements EightQueensCalculator {

  @Override
  public String eightQueens(final String[] strArr) throws CoordinateException {
    Queue<String> queenQueue = new LinkedList<>(Arrays.asList(strArr));

    String queen = queenQueue.poll();
    return checkQueens(new Coordinate(queen), queenQueue);
  }

  private String checkQueens(final Coordinate queen, Queue<String> queenQueue)
      throws CoordinateException {
    String position = checkQueen(queen, new LinkedList<>(queenQueue));

    if (position.equals(Boolean.TRUE.toString()) && queenQueue.size() > 1) {
      Coordinate coordinate = new Coordinate(queenQueue.poll());
      position = checkQueens(coordinate, queenQueue);
    }
    return position;
  }

  private String checkQueen(final Coordinate queen, Queue<String> queenQueue)
      throws CoordinateException {
    String position;
    Coordinate nextQueen = new Coordinate(queenQueue.poll());

    if (mayQueenAttack(queen, nextQueen)) {
      position = queen.toString();
    } else if (queenQueue.isEmpty()) {
      position = Boolean.TRUE.toString();
    } else {
      position = checkQueen(queen, queenQueue);
    }

    return position;
  }

  private boolean mayQueenAttack(Coordinate queen, Coordinate nextQueen) {
    return queen.getCoordinateY() == nextQueen.getCoordinateY() ||
        queen.getCoordinateX() == nextQueen.getCoordinateX() ||
        ((Math.abs(queen.getCoordinateX() - nextQueen.getCoordinateX())) -
            (Math.abs(queen.getCoordinateY() - nextQueen.getCoordinateY())) == 0);
  }
}

package service.impl;

import entity.Coordinate;
import errors.exception.CoordinateException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import service.EightQueensCalculator;

public class EightQueensCalculatorImpl implements EightQueensCalculator {

  /**
   * Determine if all of the queens are placed in such a way where none of them are attacking each
   * other. If this is true for the given input, return the string true otherwise return the first
   * queen in the list that is attacking another piece in the same format it was provided.
   *
   * @return true if any queen can attack another or the first queen coordinate who can attack
   * another
   * @throws CoordinateException if any queen coordinate is not valid
   */
  @Override
  public String eightQueens(final String[] strArr) throws CoordinateException {
    Queue<String> queenQueue = new LinkedList<>(Arrays.asList(strArr));

    String queen = queenQueue.poll();
    return checkQueens(new Coordinate(queen), queenQueue);
  }

  /**
   * Check if any queen can attack another. If so, the check ends and returns the coordinate of the
   * queen.
   *
   * @param queen the current queen that is checked
   * @param queenQueue the rest of the queens that will be checked
   * @return true if any queen can attack another or the first queen coordinate who can attack
   * another
   * @throws CoordinateException if any queen coordinate is not valid
   */
  private String checkQueens(final Coordinate queen, Queue<String> queenQueue)
      throws CoordinateException {
    String position = checkQueen(queen, new LinkedList<>(queenQueue));

    if (position.equals(Boolean.TRUE.toString()) && queenQueue.size() > 1) {
      Coordinate coordinate = new Coordinate(queenQueue.poll());
      position = checkQueens(coordinate, queenQueue);
    }
    return position;
  }

  /**
   * Check if the current queen can attack another. If so, the check ends and returns the coordinate
   * of the queen.
   *
   * @param queen the current queen that is checked
   * @param queenQueue the rest of the queens that will be checked
   * @return true if any queen can attack another or the first queen coordinate who can attack
   * another
   * @throws CoordinateException if any queen coordinate is not valid
   */
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

  /**
   * Verify that the two queens do not have the same X coordinate or the same Y coordinate, or that
   * the distance between the respective coordinates is not 0. In all cases, it implies that the
   * queens can attack each other. If the distance between the respective coordinates is 0, it
   * implies that the queens are on any diagonal of the other queen
   *
   * @param queen the first queen
   * @param nextQueen the other queen
   * @return if the first queen  who can attack another
   */
  private boolean mayQueenAttack(Coordinate queen, Coordinate nextQueen) {
    return queen.getCoordinateY() == nextQueen.getCoordinateY() ||
        queen.getCoordinateX() == nextQueen.getCoordinateX() ||
        ((Math.abs(queen.getCoordinateX() - nextQueen.getCoordinateX())) -
            (Math.abs(queen.getCoordinateY() - nextQueen.getCoordinateY())) == 0);
  }
}

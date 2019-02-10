package service;

import errors.exception.CoordinateException;

public interface EightQueensCalculator {

  /**
   * Determine if all of the queens are placed in such a way where none of them are attacking each
   * other. If this is true for the given input, return the string true otherwise return the first
   * queen in the list that is attacking another piece in the same format it was provided.
   *
   * @return true if any queen can attack another or the first queen coordinate who can attack
   * another
   * @throws CoordinateException if any queen coordinate is not valid
   */
  String eightQueens(String[] strArr) throws CoordinateException;

}

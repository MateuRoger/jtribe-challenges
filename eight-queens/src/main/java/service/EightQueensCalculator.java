package service;

import errors.exception.CoordinateException;

public interface EightQueensCalculator {

  String eightQueens(String[] strArr) throws CoordinateException;

}

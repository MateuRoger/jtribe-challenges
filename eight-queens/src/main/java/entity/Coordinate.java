package entity;

import errors.exception.CoordinateException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinate {

  private int coordinateX;
  private int coordinateY;

  public Coordinate() {
    this.coordinateX = -1;
    this.coordinateY = -1;
  }

  public Coordinate(String coord) throws CoordinateException {
    Pattern pattern = Pattern.compile("\\(([0-9]),([0-9])\\)");
    Matcher matcher = pattern.matcher(coord);

    if (matcher.matches()) {
      this.coordinateX = Integer.parseInt(matcher.group(1));
      this.coordinateY = Integer.parseInt(matcher.group(2));

    } else {
      throw new CoordinateException("The given string is not correct");
    }
  }

  public int getCoordinateX() {
    return coordinateX;
  }

  public Coordinate setCoordinateX(int coordinateX) {
    this.coordinateX = coordinateX;
    return this;
  }

  public int getCoordinateY() {
    return coordinateY;
  }

  public Coordinate setCoordinateY(int coordinateY) {
    this.coordinateY = coordinateY;
    return this;
  }

  public boolean isEmpty() {
    return coordinateX < 0 && coordinateY < 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coordinate coordinate = (Coordinate) o;
    return coordinateX == coordinate.coordinateX &&
        coordinateY == coordinate.coordinateY;
  }

  @Override
  public int hashCode() {
    return Integer.parseInt(String.valueOf(coordinateX + coordinateY));
  }

  @Override
  public String toString() {
    return "(" + coordinateX + "," + coordinateY + ')';
  }
}

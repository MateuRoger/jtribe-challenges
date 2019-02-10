package entity;

import errors.exception.CoordinateException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This entity represents the coordinates where the queens are located.
 */
public class Coordinate {

  private int coordinateX;
  private int coordinateY;

  /**
   * Construct an invalid coordinate to represent an empty coordinate
   */
  public Coordinate() {
    this.coordinateX = -1;
    this.coordinateY = -1;
  }

  /**
   * Construct a coordinate from the given coordinate string
   *
   * @param coord {@link Coordinate}
   * @throws CoordinateException if the coordinate string is not valid
   */
  public Coordinate(final String coord) throws CoordinateException {
    this();
    Pattern pattern = Pattern.compile("\\(([0-9]),([0-9])\\)");
    Matcher matcher = pattern.matcher(coord);

    if (matcher.matches()) {
      setCoordinateX(Integer.parseInt(matcher.group(1)));
      setCoordinateY(Integer.parseInt(matcher.group(2)));

    } else {
      throw new CoordinateException("The given string is not correct");
    }
  }

  /**
   * The X coordinate getter
   *
   * @return {@code coordinateX}
   */
  public int getCoordinateX() {
    return coordinateX;
  }

  /**
   * The X coordinate setter
   *
   * @param coordinateX the X coordinate to set
   * @return the {@link Coordinate} itself
   */
  public Coordinate setCoordinateX(int coordinateX) {
    this.coordinateX = coordinateX;
    return this;
  }

  /**
   * The Y coordinate getter
   *
   * @return {@code coordinateY}
   */
  public int getCoordinateY() {
    return coordinateY;
  }

  /**
   * The Y coordinate  setter
   *
   * @param coordinateY the Y coordinate to set
   * @return the {@link Coordinate} itself
   */
  public Coordinate setCoordinateY(int coordinateY) {
    this.coordinateY = coordinateY;
    return this;
  }

  @Override
  public String toString() {
    return "(" + coordinateX + "," + coordinateY + ')';
  }


}

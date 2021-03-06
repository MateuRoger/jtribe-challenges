package entity;

public class Coordinate {

  private int coordinateX;
  private int coordinateY;

  public Coordinate() {
    this.coordinateX = -1;
    this.coordinateY = -1;
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
}

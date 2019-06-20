package entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WarMap {

  private final String[] warMapStr;

  public WarMap(final String[] warMapStr) {
    this.warMapStr = warMapStr;
  }

  public String[] getWarMapStr() {
    return this.warMapStr;
  }

  public Coordinate getMaxCoord() {
    return new Coordinate().setCoordinateX(this.warMapStr.length)
        .setCoordinateY(this.warMapStr[0].length());

  }

  public char getValueOfCoord(final Coordinate coordinate) {
    return this.warMapStr[coordinate.getCoordinateY()].charAt(coordinate.getCoordinateX());
  }

  public boolean isCoordWithinMap(final Coordinate coordinate) {
    return (
        (coordinate.getCoordinateX() < this.warMapStr[0].length()
            && coordinate.getCoordinateX() >= 0)
            && (coordinate.getCoordinateY() < this.warMapStr.length)
            && coordinate.getCoordinateY() >= 0);
  }

  public Coordinate getRightCoordinate(final Coordinate actualCoord) {
    final Coordinate coordinate = new Coordinate()
        .setCoordinateX(actualCoord.getCoordinateX() + 1)
        .setCoordinateY(actualCoord.getCoordinateY());

    return isCoordWithinMap(coordinate) ? coordinate : coordinate.setCoordinateX(0);
  }

  public Coordinate getLeftCoordinate(final Coordinate actualCoord) {
    final Coordinate coordinate = new Coordinate()
        .setCoordinateX(actualCoord.getCoordinateX() - 1)
        .setCoordinateY(actualCoord.getCoordinateY());

    return isCoordWithinMap(coordinate) ? coordinate
        : coordinate.setCoordinateX(this.warMapStr[0].length() - 1);
  }

  public Coordinate getUpCoordinate(@NotNull final Coordinate actualCoord) {
    final Coordinate coordinate = new Coordinate()
        .setCoordinateX(actualCoord.getCoordinateX())
        .setCoordinateY(actualCoord.getCoordinateY() - 1);

    return isCoordWithinMap(coordinate) ? coordinate
        : coordinate.setCoordinateY(this.warMapStr.length - 1);
  }

  public Coordinate getDownCoordinate(@NotNull final Coordinate actualCoord) {
    final Coordinate coordinate = new Coordinate()
        .setCoordinateX(actualCoord.getCoordinateX())
        .setCoordinateY(actualCoord.getCoordinateY() + 1);

    return isCoordWithinMap(coordinate) ? coordinate : coordinate.setCoordinateX(0);
  }

  public void setCoordinate(@NotNull final Coordinate coord, @NotEmpty final char value) {
    StringBuilder newCoordRow = new StringBuilder(this.warMapStr[coord.getCoordinateX()]);
    newCoordRow.setCharAt(coord.getCoordinateY(), value);
    this.warMapStr[coord.getCoordinateX()] = newCoordRow.toString();
  }
}

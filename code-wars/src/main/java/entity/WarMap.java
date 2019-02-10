package entity;

public class WarMap {

  private String[] warMapStr = new String[] {("0")};

  public String[] getWarMapStr() {
    return warMapStr;
  }

  public WarMap setWarMapStr(String[] warMapStr) {
    this.warMapStr = warMapStr;
    return this;
  }

  public char getValueOfCoord(Coordinate coordinate) {
    return warMapStr[coordinate.getCoordinateY()].charAt(coordinate.getCoordinateX());
  }

  public Coordinate getMaxCoord() {
    return new Coordinate().setCoordinateX(warMapStr.length).setCoordinateY(warMapStr[0].length());

  }

  public boolean isCoordIsWithinMap(Coordinate coordinate) {
    return (
        (coordinate.getCoordinateX() < warMapStr[0].length() && coordinate.getCoordinateX() >= 0)
            && (coordinate.getCoordinateY() < warMapStr.length)
            && coordinate.getCoordinateY() >= 0);
  }

  public Coordinate getRightCoordinate(Coordinate actualCoord) {
    Coordinate coordinate = new Coordinate()
        .setCoordinateX(actualCoord.getCoordinateX() + 1)
        .setCoordinateY(actualCoord.getCoordinateY());

    return isCoordIsWithinMap(coordinate) ? coordinate : coordinate.setCoordinateX(0);
  }

  public Coordinate getLeftCoordinate(Coordinate actualCoord) {
    Coordinate coordinate = new Coordinate()
        .setCoordinateX(actualCoord.getCoordinateX() - 1)
        .setCoordinateY(actualCoord.getCoordinateY());

    return isCoordIsWithinMap(coordinate) ? coordinate
        : coordinate.setCoordinateX(warMapStr[0].length() - 1);
  }

  public Coordinate getUpCoordinate(Coordinate actualCoord) {
    Coordinate coordinate = new Coordinate()
        .setCoordinateX(actualCoord.getCoordinateX())
        .setCoordinateY(actualCoord.getCoordinateY() - 1);

    return isCoordIsWithinMap(coordinate) ? coordinate
        : coordinate.setCoordinateY(warMapStr.length - 1);
  }

  public Coordinate getDownCoordinate(Coordinate actualCoord) {
    Coordinate coordinate = new Coordinate()
        .setCoordinateX(actualCoord.getCoordinateX())
        .setCoordinateY(actualCoord.getCoordinateY() + 1);

    return isCoordIsWithinMap(coordinate) ? coordinate : coordinate.setCoordinateX(0);
  }
}

package entity;

import errors.exceptions.CoordOutOfMapException;

public class WarMap {

  private String[] warMapStr = new String[]{("0")};

  public WarMap() {
  }

  public String[] getWarMapStr() {
    return warMapStr;
  }

  public WarMap setWarMapStr(String[] warMapStr) {
    this.warMapStr = warMapStr;
    return this;
  }

  public char getValueOfCoord(Coordinate coordinate){
    return warMapStr[coordinate.getCoordinateY()].charAt(coordinate.getCoordinateX());
  }

  public Coordinate getMaxCoord(){
    return new Coordinate().setCoordinateX(warMapStr.length).setCoordinateY(warMapStr[0].length());

  }

  public boolean isCoordIsWithinMap(Coordinate coordinate) {
    return (!(coordinate.getCoordinateX() <= warMapStr[0].length()) || !(coordinate.getCoordinateX() <= warMapStr.length));
  }
}

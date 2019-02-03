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
    checkIfCoordIsWithinMap(coordinate);
    return warMapStr[coordinate.getCoordinateY()].charAt(coordinate.getCoordinateX());
  }

  public Coordinate getMaxCoord(){
    return new Coordinate().setCoordinateX(warMapStr.length).setCoordinateY(warMapStr[0].length());

  }

  private void checkIfCoordIsWithinMap(Coordinate coordinate) {
    if(!(coordinate.getCoordinateX() <= warMapStr[0].length()) || !(coordinate.getCoordinateX() <= warMapStr.length))
      throw new CoordOutOfMapException("This coordinate  isn't within map");
  }
}

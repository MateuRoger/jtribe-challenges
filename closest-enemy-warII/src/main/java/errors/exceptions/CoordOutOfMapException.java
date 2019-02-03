package errors.exceptions;

public class CoordOutOfMapException extends RuntimeException{

  public CoordOutOfMapException(Throwable cause) {
    super(cause);
  }

  public CoordOutOfMapException(String message) {
    super(message);
  }
}

package exceptions;

public class InvalidPositionException extends RuntimeException {
	  public InvalidPositionException(String err) {
	    super(err);
	  }
	  public InvalidPositionException() {
	    /* default constructor */
	  }
	}

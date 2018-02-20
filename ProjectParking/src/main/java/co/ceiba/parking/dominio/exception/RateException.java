package co.ceiba.parking.dominio.exception;

public class RateException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public RateException(String message) {
		super(message);
	}
}

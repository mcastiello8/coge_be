package it.prova.coge_be.web.api.exception;

public class RisorsaNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RisorsaNotFoundException(String message) {
		super(message);
	}
}

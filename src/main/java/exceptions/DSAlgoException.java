package exceptions;

public class DSAlgoException extends RuntimeException {

	private static final long serialVersionUID = 3146363909580016903L;

	public DSAlgoException() {
	}

	public DSAlgoException(String message) {
		super(message);
	}
}

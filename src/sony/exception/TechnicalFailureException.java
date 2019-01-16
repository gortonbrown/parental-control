package sony.exception;

public class TechnicalFailureException extends Error {
	public TechnicalFailureException(String message) {
		super("Unfortunately, due to a system error you will not be able to watch this movie.");
	}
}
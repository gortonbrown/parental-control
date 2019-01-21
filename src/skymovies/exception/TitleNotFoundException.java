package skymovies.exception;

public class TitleNotFoundException extends Exception {
	public TitleNotFoundException() {
		super("Unfortunately, The movie service could not find the requested movie");
	}
}
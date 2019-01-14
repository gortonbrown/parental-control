package sony.service;

import sony.exception.TechnicalFailureException;
import sony.exception.TitleNotFoundException;

public interface MovieService {
	 String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}

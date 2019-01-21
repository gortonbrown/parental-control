package skymovies.service;

import skymovies.exception.TechnicalFailureException;
import skymovies.exception.TitleNotFoundException;

public interface MovieService {
	 String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
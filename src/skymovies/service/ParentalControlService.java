package skymovies.service;

import skymovies.controller.MovieController;
import skymovies.exception.*;
import skymovies.model.Movie;

public class ParentalControlService implements MovieService {
	
	@Override
	public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
		Movie movie = MovieController.getMovieById(movieId);
	
		return String.valueOf(movie.getMovieCategory().getMovieLevel());
	}
}
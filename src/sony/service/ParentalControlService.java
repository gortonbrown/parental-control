package sony.service;

import sony.controller.MovieController;
import sony.exception.*;
import sony.model.Movie;

public class ParentalControlService implements MovieService {
	
	@Override
	public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
		Movie movie = MovieController.getMovieById(movieId);
	
		return String.valueOf(movie.movieCategory.ordinal());
	}
}
package sony.service;

import sony.controller.CustomerMovieController;
import sony.exception.TechnicalFailureException;
import sony.exception.TitleNotFoundException;
import sony.model.Movie;
import sony.model.MovieCustomer;

public class CustomerMovieService {
	public boolean displayMovieForCustomer(MovieCustomer customer, Movie movie) throws TitleNotFoundException, TechnicalFailureException {
		return CustomerMovieController.displayMovieForCustomer(customer, movie);
	}
}

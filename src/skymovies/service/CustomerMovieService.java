package skymovies.service;

import skymovies.controller.CustomerMovieController;
import skymovies.exception.TechnicalFailureException;
import skymovies.exception.TitleNotFoundException;
import skymovies.model.Movie;
import skymovies.model.MovieCustomer;

public class CustomerMovieService {
	public boolean displayMovieForCustomer(MovieCustomer customer, Movie movie) throws TitleNotFoundException, TechnicalFailureException {
		return CustomerMovieController.displayMovieForCustomer(customer, movie);
	}
}
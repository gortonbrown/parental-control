package skymovies.controller;

import skymovies.exception.TechnicalFailureException;
import skymovies.exception.TitleNotFoundException;
import skymovies.model.Customer;
import skymovies.model.Movie;
import skymovies.model.MovieCustomer;
import skymovies.service.ParentalControlService;

public class CustomerMovieController {
	
	public static boolean displayMovieForCustomer(MovieCustomer customer, Movie selectedMovie) throws TitleNotFoundException, TechnicalFailureException {
		ParentalControlService parentalControlService = new ParentalControlService();
		String controlLevel = parentalControlService.getParentalControlLevel(selectedMovie.getId());
		
		return isMovieWithinParentalControlLevel(controlLevel, customer);
	}
	
	private static boolean isMovieWithinParentalControlLevel(String movieControlLevel, MovieCustomer customer){
		boolean customerCanView = false;
		if(customer.movieCategoryPreferencce.getMovieLevel() >= Integer.valueOf(movieControlLevel))
			customerCanView = true;
		 
		return customerCanView;
	}
}
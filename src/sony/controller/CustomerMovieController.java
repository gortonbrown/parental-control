package sony.controller;

import sony.exception.TechnicalFailureException;
import sony.exception.TitleNotFoundException;
import sony.model.Customer;
import sony.model.Movie;
import sony.model.MovieCustomer;
import sony.service.ParentalControlService;

public class CustomerMovieController {
	
	public static boolean displayMovieForCustomer(MovieCustomer customer, Movie selectedMovie) throws TitleNotFoundException, TechnicalFailureException {
		ParentalControlService parentalControlService = new ParentalControlService();
		String controlLevel = parentalControlService.getParentalControlLevel(selectedMovie.getId());
		
		return isMovieWithinParentalControlLevel(controlLevel, customer);
	}
	
	private static boolean isMovieWithinParentalControlLevel(String movieControlLevel, MovieCustomer customer){
		if(Integer.valueOf(movieControlLevel) > customer.movieCategoryPreferencce.ordinal())
			return false;
		else 
			return true;
	}
}

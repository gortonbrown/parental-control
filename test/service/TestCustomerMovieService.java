package service;

import org.junit.Assert;
import org.junit.Test;

import skymovies.controller.MovieController;
import skymovies.exception.TechnicalFailureException;
import skymovies.exception.TitleNotFoundException;
import skymovies.model.Movie;
import skymovies.model.MovieCategory;
import skymovies.model.MovieCustomer;
import skymovies.service.CustomerMovieService;

public class TestCustomerMovieService {

	@Test
	public void testCustomerWith_PG_Rating_ShouldNotHaveAccessTo_18_Movie() {
		CustomerMovieService customerMovieService = new CustomerMovieService();
		boolean customerCanView = false;
		MovieCustomer movieCustomer = createCustomer(MovieCategory.PG);
		Movie scaryHolidays = createMovie(MovieCategory.Eighteen);
		
		MovieController.addMovie(scaryHolidays);

		try {
			customerCanView = customerMovieService.displayMovieForCustomer(movieCustomer, scaryHolidays);
		} catch (TitleNotFoundException | TechnicalFailureException e) {
			e.printStackTrace();
		}

		Assert.assertFalse(customerCanView);
	}

	@Test
	public void testCustomerWith_PG_Rating_ShouldHaveAccessTo_PG_Movie() {
		CustomerMovieService customerMovieService = new CustomerMovieService();
		boolean customerCanView = false;
		MovieCustomer movieCustomer = createCustomer(MovieCategory.PG);
		Movie happyHolidays = createMovie(MovieCategory.PG);

		MovieController.addMovie(happyHolidays);

		try {
			customerCanView = customerMovieService.displayMovieForCustomer(movieCustomer, happyHolidays);
		} catch (TitleNotFoundException | TechnicalFailureException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(customerCanView);
	}

	@Test
	public void testCustomerWith_18_Rating_ShouldHaveAccessTo_PG_Movie() {
		CustomerMovieService customerMovieService = new CustomerMovieService();
		boolean customerCanView = false;
		MovieCustomer movieCustomer = createCustomer(MovieCategory.Eighteen);
		Movie happyHolidays = createMovie(MovieCategory.PG);

		MovieController.addMovie(happyHolidays);

		try {
			customerCanView = customerMovieService.displayMovieForCustomer(movieCustomer, happyHolidays);
		} catch (TitleNotFoundException | TechnicalFailureException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(customerCanView);
	}

	private Movie createMovie(MovieCategory movieCategory) {
		Movie movie = new Movie();
		movie.setTitle("Deathly holidays");
		movie.setMovieCategory(movieCategory);
		movie.setId("0000100654");

		return movie;
	}

	private MovieCustomer createCustomer(MovieCategory customerCategory) {
		MovieCustomer movieCustomer = new MovieCustomer();
		movieCustomer.setFirstname("Bob");
		movieCustomer.setFirstname("Jones");
		movieCustomer.setMovieCategoryPreferencce(customerCategory);
		movieCustomer.selectMovie(MovieController.getMovieByTitle("deathlyHolidays"));
		return movieCustomer;
	}
}

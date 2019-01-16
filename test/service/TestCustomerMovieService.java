package service;

import org.junit.Assert;
import org.junit.Test;

import sony.controller.MovieController;
import sony.exception.TechnicalFailureException;
import sony.exception.TitleNotFoundException;
import sony.model.Movie;
import sony.model.MovieCategory;
import sony.model.MovieCustomer;
import sony.service.CustomerMovieService;

public class TestCustomerMovieService {

	@Test
	public void testCustomerWith_PG_Rating_ShouldNotHaveAccessTo_18_Movie() {
		CustomerMovieService customerMovieService = new CustomerMovieService();
		boolean customerCanView = false;
		MovieCustomer movieCustomer = createCustomer(MovieCategory.PG);
		Movie deathlyHolidays = createMovie(MovieCategory.Eighteen);
		
		MovieController.addMovie(deathlyHolidays);

		try {
			customerCanView = customerMovieService.displayMovieForCustomer(movieCustomer, deathlyHolidays);
		} catch (TitleNotFoundException | TechnicalFailureException e) {
			e.printStackTrace();
		}

		Assert.assertFalse(customerCanView);
	}

	@Test
	public void testCustomerWith_PG_Rating_ShouldHaveAccessTo_18_Movie() {
		CustomerMovieService customerMovieService = new CustomerMovieService();
		boolean customerCanView = false;
		MovieCustomer movieCustomer = createCustomer(MovieCategory.PG);
		Movie deathlyHolidays = createMovie(MovieCategory.PG);

		MovieController.addMovie(deathlyHolidays);

		try {
			customerCanView = customerMovieService.displayMovieForCustomer(movieCustomer, deathlyHolidays);
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
		Movie deathlyHolidays = createMovie(MovieCategory.PG);

		MovieController.addMovie(deathlyHolidays);

		try {
			customerCanView = customerMovieService.displayMovieForCustomer(movieCustomer, deathlyHolidays);
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

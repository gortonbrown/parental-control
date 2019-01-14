import static org.junit.Assert.*;

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
	public void test() {
		MovieCustomer movieCustomer = new MovieCustomer();
		
		Movie deathlyHolidays = new Movie();
		deathlyHolidays.setTitle("Deathly holidays");
		deathlyHolidays.setMovieCategory(MovieCategory.Eighteen);
		deathlyHolidays.setId("0000100654");
		
		movieCustomer.setFirstname("Bob");
		movieCustomer.setFirstname("Jones");
		movieCustomer.setMovieCategoryPreferencce(MovieCategory.PG);
		movieCustomer.selectMovie(MovieController.getMovieByTitle("deathlyHolidays"));
		
		MovieController.addMovie(deathlyHolidays);
		
		CustomerMovieService customerMovieService = new CustomerMovieService();
		
		try {
			Assert.assertTrue(customerMovieService.displayMovieForCustomer(movieCustomer, deathlyHolidays));
		} catch (TitleNotFoundException | TechnicalFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

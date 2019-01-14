import static org.junit.Assert.*;
import org.junit.Test;

import sony.controller.MovieController;
import sony.exception.TechnicalFailureException;
import sony.exception.TitleNotFoundException;
import sony.model.Movie;
import sony.model.MovieCategory;
import sony.service.ParentalControlService;



public class TestParentalControlService {
	private ParentalControlService parentalControlService;

	@Test
	public void testCategory12Is2ndItemInEnum() {
		parentalControlService = new ParentalControlService();
	
		MovieController.addMovie(createMovie());
		
		try {
			assertEquals("2", parentalControlService.getParentalControlLevel("0000100054"));
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		} catch (TechnicalFailureException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = sony.exception.TitleNotFoundException.class)
	public void testSearchForNonExistantMovieWillThrowTitleNotFound() {
		parentalControlService = new ParentalControlService();
	
		MovieController.addMovie(createMovie("0000100054"));
		
		try {
			assertEquals("Unfortunately, The movie service could not find the requested movie", parentalControlService.getParentalControlLevel("0000107054"));
		} catch (TitleNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (TechnicalFailureException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		/*try {
			assertEquals("2", parentalControlService.getParentalControlLevel("0000107054"));
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		} catch (TechnicalFailureException e) {
			e.printStackTrace();
		}*/
	}
	
	private Movie createMovie() {
		Movie deathlyHolidays = new Movie();
		deathlyHolidays.setTitle("Deathly holidays");
		deathlyHolidays.setMovieCategory(MovieCategory.Twelve);
		deathlyHolidays.setId("0000100054");
		
		return deathlyHolidays;
	}
	
	private Movie createMovie(String movieId) {
		Movie deathlyHolidays = new Movie();
		deathlyHolidays.setTitle("Deathly holidays");
		deathlyHolidays.setMovieCategory(MovieCategory.Twelve);
		deathlyHolidays.setId(movieId);
		
		return deathlyHolidays;
	}
}

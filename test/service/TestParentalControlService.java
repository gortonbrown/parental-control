package service;

import org.junit.Assert;
import org.junit.Rule																																																							;
import org.junit.*;
import org.junit.rules.ExpectedException;

import skymovies.controller.MovieController;
import skymovies.exception.TechnicalFailureException;
import skymovies.exception.TitleNotFoundException;
import skymovies.model.Movie;
import skymovies.model.MovieCategory;
import skymovies.service.ParentalControlService;


public class TestParentalControlService {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	private ParentalControlService parentalControlService;
	
	
	@Before
	public void createParentalControlService() {
		parentalControlService = new ParentalControlService();	
	}
	
	@After
	public void emptyMovieList() {
		MovieController.SonyMovieList.clear();
	}

	@Test
	public void testCategory12_is_2_ItemInEnum() {
		String movieCategory = "";	
		Movie skyMovie = createMovie();
	
		MovieController.addMovie(createMovie(MovieCategory.Twelve));
		
		try {
			movieCategory =  callParentalControlService(skyMovie.getId());
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		} catch (TechnicalFailureException e) {
			e.printStackTrace();
		}

		Assert.assertEquals("2", movieCategory);
	}
	
	@Test
	public void testCategoryUis_0_ItemInEnum() {
		String movieCategory = "";
		Movie skyMovie = createMovie();
	
		MovieController.addMovie(createMovie(MovieCategory.U));
		
		try {
			movieCategory =  callParentalControlService(skyMovie.getId());
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		} catch (TechnicalFailureException e) {
			e.printStackTrace();
		}

		Assert.assertEquals("0", movieCategory);
	}

	private String callParentalControlService(String movieId) throws TitleNotFoundException, TechnicalFailureException {
		return parentalControlService.getParentalControlLevel(movieId);
	}
	
	@Test
	public void testSearchForNonExistantMovieWillThrowTitleNotFound() throws skymovies.exception.TitleNotFoundException {
		MovieController.addMovie(createMovie("00001000694"));

		thrown.expect(skymovies.exception.TitleNotFoundException.class);

		callParentalControlService("000010003694");
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
	
	private Movie createMovie(MovieCategory category) {
		Movie deathlyHolidays = new Movie();
		deathlyHolidays.setTitle("Deathly holidays");
		deathlyHolidays.setMovieCategory(category); 
		deathlyHolidays.setId("0000100054");
		
		return deathlyHolidays;
	}
}

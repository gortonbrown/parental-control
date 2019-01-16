package service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule																																																							;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.*;
import org.junit.runners.BlockJUnit4ClassRunner;

import sony.controller.MovieController;
import sony.exception.TechnicalFailureException;
import sony.exception.TitleNotFoundException;
import sony.model.Movie;
import sony.model.MovieCategory;
import sony.service.ParentalControlService;


//@RunWith(value = BlockJUnit4ClassRunner.class)
public class TestParentalControlService {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private ParentalControlService parentalControlService;

	@Test
	public void testCategory12Is2ndItemInEnum() {
		parentalControlService = new ParentalControlService();
		String movieCategory = "";
	
		MovieController.addMovie(createMovie());
		
		try {
			movieCategory =  parentalControlService.getParentalControlLevel("0000100054");
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		} catch (TechnicalFailureException e) {
			e.printStackTrace();
		}

		Assert.assertEquals("2", movieCategory);
	}

	private String callParentalControlService(String movieId) throws TitleNotFoundException, TechnicalFailureException {
		return parentalControlService.getParentalControlLevel(movieId);
	}
	
	@Test
	public void testSearchForNonExistantMovieWillThrowTitleNotFound() throws sony.exception.TitleNotFoundException																																						 {
		parentalControlService = new ParentalControlService();

		MovieController.addMovie(createMovie("00001000694"));

		thrown.expect(sony.exception.TitleNotFoundException.class);

		/*try {
			callParentalControlService("000010694");
			//fail("!!Unfortunately, The movie service could not find the requested movie");
			//Assert.fail();
		} catch (TitleNotFoundException e) {
			//Assert.assertEquals(new TitleNotFoundException().getMessage(), "Unfortunately, The movie service could not find the requested movie");
			System.out.println(e.getMessage());
		} catch (TechnicalFailureException e) {
			System.out.println("TechnicalFailureException error");
			e.printStackTrace();
		}*/

		//Assert.fail();

		callParentalControlService("000010003694");
	}

	@Test
	public void testSystemFailureWillThrowTechnicalFailure() throws sony.exception.TechnicalFailureException																																						 {
		parentalControlService = new ParentalControlService();

		MovieController.addMovie(createMovie("00001000694"));

		thrown.expect(sony.exception.TechnicalFailureException.class);

		try {
			callParentalControlService("000010694");
			//fail("!!Unfortunately, The movie service could not find the requested movie");
			//Assert.fail();
		} catch (TitleNotFoundException e) {
			//Assert.assertEquals(new TitleNotFoundException().getMessage(), "Unfortunately, The movie service could not find the requested movie");
			System.out.println(e.getMessage());
		} catch (TechnicalFailureException e) {
			fail();
			System.out.println("TechnicalFailureException error");
			e.printStackTrace();
		}

		//Assert.fail();

		//callParentalControlService("000010003694");
	}

	@Test
	public void testSearchMovieByIdWillReturnCorrectMovie() throws sony.exception.TitleNotFoundException																																						 {
		parentalControlService = new ParentalControlService();

		MovieController.addMovie(createMovie("00001000694"));

		//thrown.expect(sony.exception.TitleNotFoundException.class);

		/*try {
			callParentalControlService("000010694");
			//fail("!!Unfortunately, The movie service could not find the requested movie");
			//Assert.fail();
		} catch (TitleNotFoundException e) {
			//Assert.assertEquals(new TitleNotFoundException().getMessage(), "Unfortunately, The movie service could not find the requested movie");
			System.out.println(e.getMessage());
		} catch (TechnicalFailureException e) {
			System.out.println("TechnicalFailureException error");
			e.printStackTrace();
		}*/

		//Assert.fail();

		String movieID = callParentalControlService("00001000694");


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

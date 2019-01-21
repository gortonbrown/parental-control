package controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import skymovies.controller.MovieController;
import skymovies.exception.TitleNotFoundException;
import skymovies.model.Movie;
import skymovies.model.MovieCategory;

public class TestMovieController {
	
	@After
	public void emptyMovieList() {
		MovieController.SonyMovieList.clear();
	}

	@Test
	public void testSearchByIdReturnsCorrectMovie() {	
		MovieController.addMovie(createMovie("Amazing holidays", "0000100054"));
		MovieController.addMovie(createMovie("Amazing Spiderman", "00008850054"));
		MovieController.addMovie(createMovie("Amazing Miles Morales", "0000100093665"));
		
		Movie retrievedMovie = null;
		try {
			retrievedMovie = MovieController.getMovieById("00008850054");
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		}

		Assert.assertEquals("Amazing Spiderman", retrievedMovie.getTitle());
	}
	
	@Test
	public void testSearchByTitleReturnsCorrectMovie() {
		MovieController.addMovie(createMovie("Amazing holidays", "0000100054"));
		MovieController.addMovie(createMovie("Amazing Spiderman", "00008850054"));
		MovieController.addMovie(createMovie("Amazing Miles Morales", "0000100093665"));
		
		Movie retrievedMovie = MovieController.getMovieByTitle("Amazing Miles Morales");
		
		Assert.assertEquals("0000100093665", retrievedMovie.getId());
	}
	
	private Movie createMovie(String title, String id) {
		Movie deathlyHolidays = new Movie();
		deathlyHolidays.setTitle(title);
		deathlyHolidays.setMovieCategory(MovieCategory.Twelve);
		deathlyHolidays.setId(id);
		
		return deathlyHolidays;
	}
}

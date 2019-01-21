package model;

import org.junit.Assert;
import org.junit.Test;

import skymovies.model.MovieCategory;

public class TestMovieCategory {

	@Test
	public void testCategoryEighteenReturns_18() {
		MovieCategory movieCategory = MovieCategory.Eighteen;
		
		Assert.assertEquals("18", movieCategory.getMovieRating());
	}
	
	@Test
	public void testCategoryPGReturnsPG() {
		MovieCategory movieCategory = MovieCategory.PG;
		
		Assert.assertEquals("PG", movieCategory.getMovieRating());
	}
	
	@Test
	public void testCategoryPGisLevel2() {
		MovieCategory movieCategory = MovieCategory.PG;
		
		Assert.assertEquals(1, movieCategory.getMovieLevel());
	}
}
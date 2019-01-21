package skymovies.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import skymovies.exception.TitleNotFoundException;
import skymovies.model.Movie;

import java.util.Set;

public class MovieController {
	public static HashMap<String, Movie> SonyMovieList = new HashMap<String, Movie>();
	
	public static void addMovie(Movie movie){
		SonyMovieList.put(movie.getId(), movie);
	}
	
	public static Movie getMovieById(String movieId) throws TitleNotFoundException{
		if (!SonyMovieList.containsKey(movieId)){
			throw new TitleNotFoundException();
		}else{
			return SonyMovieList.get(movieId);
		}
	}
	
	public static Movie getMovieByTitle(String movieTitle) {
		Movie movie = null;
		Set<Entry<String, Movie>> movies = SonyMovieList.entrySet();
		Iterator<Entry<String, Movie>> iterator = movies.iterator();
		
		while(iterator.hasNext()) {
			Movie testMovie = iterator.next().getValue();
			if (testMovie.getTitle().equals(movieTitle)) {			
				movie = testMovie;
			}
		}
		
		return movie;
	}
}
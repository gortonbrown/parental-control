package sony.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import sony.exception.TitleNotFoundException;
import sony.model.Movie;

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
	
	public static Movie getMovieByTitle(String movieTitle){
		Movie movie = null;
		Set<Entry<String, Movie>> movies = SonyMovieList.entrySet();
		Iterator<Entry<String, Movie>> iterator = movies.iterator();
		
		while(iterator.hasNext()){
			if (iterator.next().getValue().getTitle().equals(movieTitle))
				movie = iterator.next().getValue();
		}
		
		return movie;
	}
	
	public String getMovieCategory(Movie movie){
		return movie.getMovieCategory();
	}
}

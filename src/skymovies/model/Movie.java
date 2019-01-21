package skymovies.model;

public class Movie {
	private String title;
	private MovieCategory movieCategory;
	private String id;
	
	public String getTitle() {
		return title;
	}
	
	public String getMovieRating() {
		return movieCategory.getMovieRating();
	}
	
	public MovieCategory getMovieCategory() {
		return movieCategory;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setMovieCategory(MovieCategory movieCategory) {
		this.movieCategory = movieCategory;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}  
}

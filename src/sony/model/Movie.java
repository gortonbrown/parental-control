package sony.model;

public class Movie {
	public String title;
	public MovieCategory movieCategory;
	public String id;
	
	public String getTitle() {
		return title;
	}
	public String getMovieCategory() {
		return movieCategory.getMovieCategory();
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

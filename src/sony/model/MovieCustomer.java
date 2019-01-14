
package sony.model;

public class MovieCustomer extends Customer {
	public MovieCategory movieCategoryPreferencce;
	public Movie selectedMovie;

	public MovieCategory getMovieCategoryPreferencce() {
		return movieCategoryPreferencce;
	}

	public void setMovieCategoryPreferencce(MovieCategory movieCategoryPreferencce) {
		this.movieCategoryPreferencce = movieCategoryPreferencce;
	}

	public void selectMovie(Movie selectedMovie) {
		this.selectedMovie = selectedMovie;
	}
	
	public Movie getSelectMovie() {
		return selectedMovie;
	}
}
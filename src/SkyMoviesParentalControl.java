import skymovies.controller.MovieController;
import skymovies.exception.TechnicalFailureException;
import skymovies.exception.TitleNotFoundException;
import skymovies.model.Movie;
import skymovies.model.MovieCategory;
import skymovies.model.MovieCustomer;
import skymovies.service.CustomerMovieService;
import skymovies.service.ParentalControlService;

public class SkyMoviesParentalControl {
	
	private static Integer movieId = 120003451;
	private ParentalControlService parentalControlService;
	private CustomerMovieService customerMovieService;
	
	public SkyMoviesParentalControl(){
		parentalControlService = new ParentalControlService();
		customerMovieService = new CustomerMovieService();
	}
	
	public static void addMovie(Movie movie){
		MovieController.addMovie(movie);
	}
	
	public Movie createMovie(String movieTitle, MovieCategory movieCategory) {
		Movie movie = new Movie();
		movie.setTitle(movieTitle);
		movie.setMovieCategory(movieCategory);
		
		//normally I this would be a given id instead of a generated one
		movie.setId(movieId.toString());
		movieId++;
		
		return movie;
	}

	public MovieCustomer createCustomer(String firstname, String surname, MovieCategory customerCategory) {
		MovieCustomer movieCustomer = new MovieCustomer();
		movieCustomer.setFirstname(firstname);
		movieCustomer.setFirstname(surname);
		movieCustomer.setMovieCategoryPreferencce(customerCategory);
		return movieCustomer;
	}
	
	public String getParentalControlLevel(String movieID){
		String controlLevel="";
		try {
			controlLevel = parentalControlService.getParentalControlLevel(movieID);
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		} catch (TechnicalFailureException e) {
			e.printStackTrace();
		}
		
		return controlLevel;
	}
	
	public boolean canCustomerViewMovie(MovieCustomer customer, Movie movie) {
		try {
			return customerMovieService.displayMovieForCustomer(customer, movie);
		} catch (TitleNotFoundException | TechnicalFailureException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static void main(String args[]){
		SkyMoviesParentalControl sonyParentControl = new SkyMoviesParentalControl();
		
		MovieCustomer marion = sonyParentControl.createCustomer("Marion", "Brown", MovieCategory.Twelve);
		MovieCustomer georgia = sonyParentControl.createCustomer("Georgia", "Brown", MovieCategory.PG);
		MovieCustomer noah = sonyParentControl.createCustomer("Noah", "Brown", MovieCategory.U);
		
		Movie holidays = sonyParentControl.createMovie("Amazing holidays", MovieCategory.Eighteen);
		Movie amazing = sonyParentControl.createMovie("Amazing Spiderman", MovieCategory.PG);
		Movie miles = sonyParentControl.createMovie("Amazing Miles Morales", MovieCategory.U);
		
		addMovie(holidays);
		addMovie(amazing);
		addMovie(miles);
		
		boolean marionHolidayResult = sonyParentControl.canCustomerViewMovie(marion, holidays);
		boolean georgiaHolidaysResult = sonyParentControl.canCustomerViewMovie(georgia, holidays);
		boolean georgiaAmazingResult = sonyParentControl.canCustomerViewMovie(georgia, amazing);
		boolean noahMilesResult = sonyParentControl.canCustomerViewMovie(noah, miles);
		
		System.out.println("can marion ("+marion.getMovieCategoryPreferencce()+") view "+holidays.getTitle()+"("+holidays.getMovieRating()+"): "
				+marionHolidayResult);
		
		System.out.println("can georgia ("+georgia.getMovieCategoryPreferencce()+") view "+holidays.getTitle()+"("+holidays.getMovieRating()+"): "
				+georgiaHolidaysResult);
		
		System.out.println("can georgia ("+georgia.getMovieCategoryPreferencce()+") view "+amazing.getTitle()+"("+amazing.getMovieRating()+"): "
				+georgiaAmazingResult);
		
		System.out.println("can noah ("+noah.getMovieCategoryPreferencce()+") view "+miles.getTitle()+"("+miles.getMovieRating()+"): "
				+noahMilesResult);
	}
}

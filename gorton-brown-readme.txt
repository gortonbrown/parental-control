Project Title gorton-brown-skyMovies-parental-control-service


The application
The application contains an implementation of the ParentalControlService. That will allow SkyMovie customers to only view movies that are in line with their viewing preferences. For example, they should not be able to view movies rated 12 and above if they have selected PG for their viewing preference.

SonyParentalControl has helper methods (/gorton-brown-skyMovies-parental-control-service/src/SkyMoviesParentalControl.java):
Movie createMovie(String movieTitle, MovieCategory movieCategory) to create movies
void addMovie(Movie movie) and add movies to a simulated database

MovieCustomer createCustomer(String firstname, String surname, MovieCategory customerCategory) to create a customer that watches SkyMovies. A MovieCustomer is an extension of (an assumed base) Customer that is able to set viewing preferences.

String getParentalControlLevel(String movieID) provides access to the parentalControlService that will return the category level of the provided movie

boolean canCustomerViewMovie(MovieCustomer customer, Movie movie) indicates whether the customer is able to view the requested movie based on the movie rating together with their viewing preferences.

Executing the sample application

Using an IDE Open your chosen IDE and import the unzipped directory as normal. Tests for  the application may be run from /gorton-brown-skyMovies-parental-control-service/test/AllTests.java. The application may be executed from /gorton-brown-skyMovies-parental-control-service/src/SkyMoviesParentalControl.java

From the commandline Open your normal terminal and navigate to /gorton-brown-skyMovies-parental-he control-service/src. From there compile the application by running  javac SkyMoviesParentalControl.java then java SkyMoviesParentalControl . 


java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore [test class name]

Applications / Eclipse / Contents / Eclipse



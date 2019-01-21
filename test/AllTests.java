
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import service.*;
import controller.*;
import model.*;



@RunWith(Suite.class)
@SuiteClasses({
	TestCustomerMovieService.class, 
	TestParentalControlService.class,
	TestMovieController.class,
	TestMovieCategory.class
})

public class AllTests {

}

package framework;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		// This creates cucumber reports
        plugin = {"pretty", "html:target/site/cucumber-pretty"},
        //This create auto method name in camelCase
        snippets = cucumber.api.SnippetType.CAMELCASE,
        
        //Path to your feature file
        features = {"src/test/resources/features"},
        // Specify tags to be executed
     // tags = {"@typeahead1"},
       //tags = {"@hotels-login"},
       //tags = {"@amazon-login"},
       // tags = {"@skyhomepage"},
       // tags = {"@verifytemps"},
       //   tags = {"@skytimemachine"},
       // tags = {"@hotels-destination"},
         // tags = {"@hotels-no-destination"},
        //tags = {"@hotels-invalid-destination"},
       // tags = {"@hotels-group-page"},
        //tags = {"@hotels-update-detail"},
        tags = {"@hotels-booking-page"},
        //tags = {"@signup"},
        //tags = {"@login-1"},

        //Specify step definition package name (Note: make sure to have this package on current directory) 
        glue = {"stepdefinition"}
)
public class TestRunner {

	
}

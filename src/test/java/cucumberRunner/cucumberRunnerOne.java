package cucumberRunner;

/**
 * Created by Mihail_Damasheuski on 6/24/2016.
 */

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"cucumberSteps/"},format = {"pretty","json:target/cucumberReport.json"},features = {"src/test/java/cucumberFeatures"},tags = {"@Thread1,@Thread2"})
public class cucumberRunnerOne {
}

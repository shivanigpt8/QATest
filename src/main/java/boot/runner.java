package boot;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:features",glue="classpath:glue",
        tags = "@todoist", plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true)
public class runner {
}

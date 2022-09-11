package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(
		features =  {"src/test/java/features"}
		,glue = "steps"
		,monochrome = false
//		,tags = "@browser"
		,dryRun = false
		,plugin = {"pretty", "html:target/html/cucumber-default-report.html", "json:target/cucumber.json", "rerun:target/failed.txt"}
)

public class TestRunner {}
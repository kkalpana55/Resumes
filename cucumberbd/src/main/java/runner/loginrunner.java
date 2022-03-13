package runner;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
/*import org.testng.annotations.Test;*/
/*import gherkin.formatter.Reporter;*/

@RunWith(Cucumber.class)
		@CucumberOptions(
				features ="C:\\Users\\User\\eclipse-workspace\\cucumberbd\\src\\main\\java\\Features\\",
				glue= {"stepdefinitions"},
				plugin = {"pretty"},
		 dryRun=false,
				 monochrome = true
		)

public class loginrunner {
private TestNGCucumberRunner testngcucumberrunner;
@BeforeClass(alwaysRun=true)

public void setUpClass() throws Exception{
/*Reporter.loadXMLConfig(new File("src/test/resour
 * ces/extent-config.xml"));*/
	testngcucumberrunner = new TestNGCucumberRunner(this.getClass());
	
}
@Test(groups="cucumber",description="runs cucumber feature",dataProvider="features")
public void feature(CucumberFeatureWrapper cucumberFeature) {
	testngcucumberrunner.runCucumber(cucumberFeature.getCucumberFeature());
	
}
@DataProvider
public Object[][] features(){
		return testngcucumberrunner.provideFeatures();
	}
@AfterClass(alwaysRun=true)
	
public void teardownclass() throws Exception{
	testngcucumberrunner.finish();
}
public static void main(String[] args) {
	
}
}

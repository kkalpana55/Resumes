package runner;

import org.testng.annotations.AfterClass;
import org.junit.runner.Runner;
//import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileReader;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
/*import com.cucumber.listener.Reporter;*/

/*import org.testng.annotations.Test;*/
/*import gherkin.formatter.Reporter;*/

@RunWith(CucumberOptions.class)
		@CucumberOptions(
				features ="C:\\Users\\User\\eclipse-workspace\\cucumberbd\\src\\main\\java\\Features\\",
				glue= {"stepdefinitions"},
						plugin = {"pretty"}
			 		)

public class cucumberextentreportrunner {
	
	 /*@AfterClass
     public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("target/extent-config.xml"));
        
	 }*/
	}
    

package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="./Feature",
		glue="demoSteps",
		plugin= {"pretty","html:target/report.html"},
		monochrome = true
	 )

public class TestRunner extends AbstractTestNGCucumberTests {

}

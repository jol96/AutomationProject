package ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "json:target/cucumber-report.json"},
        features="src/main/features/UI/OrderTests.feature",
        glue="ui/stepDefinitions", monochrome = true)
public class CustomerTestRunner extends AbstractTestNGCucumberTests { }
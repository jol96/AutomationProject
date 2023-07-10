package api.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "json:target/cucumber-report.json"},
        features="src/main/features/Api/ProductsTests.feature",
        glue="api/stepDefinitions", monochrome = true)
public class ProductsTestRunner extends AbstractTestNGCucumberTests { }

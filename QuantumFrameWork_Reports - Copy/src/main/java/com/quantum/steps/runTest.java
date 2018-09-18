package com.quantum.steps;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/scenarios/VersionOne.feature", tags={"~@ignore"},
        plugin = {"json:cucumber.json"})

public class runTest {
}

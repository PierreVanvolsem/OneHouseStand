package com.example.demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format={"pretty",
        "html:target/cucumber"},
        features = {"classpath:com.example.demo"},
        tags={"~@skip"})
public class RunTests {

}

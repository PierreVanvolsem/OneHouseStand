package com.example.demo;

import com.example.demo.domain.Review;
import com.example.demo.domain.User;
import com.example.demo.service.OhsServiceImplementatie;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(Cucumber.class)
@CucumberOptions(
        format={"pretty",
        "html:target/cucumber"},
        features = {"classpath:com.example.demo"},
        tags={"~@skip"})
public class RunTests {

}

package com.example.demo;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StepDefinitions {
    WebDriver driver;

    @Given("^I am signed in as a klant$")
    public void iAmSignedInAsAKlant() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "C:\\OracleJava\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.navigate().to("http://localhost:8080/");

        driver.findElement(By.name("logout")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Je bent uitgelogd"));

        driver.navigate().to("http://localhost:8080/login");


        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "login page"));

        driver.findElement(By.id("username")).sendKeys("k");
        driver.findElement(By.id("password")).sendKeys("k");
        driver.findElement(By.name("submit")).click();

        new WebDriverWait(driver, 2); //pagina kan varieren, dus kan niet dynamisch

    }

    @Given("^I am on the page where I can add a new house$")
    public void iAmOnThePageWhereICanAddANewHouse() throws Throwable {
        driver.navigate().to("http://localhost:8080/klant/pandToevoegen");
    }

    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void iEnterInThePrijsPerUurField(String number, String fieldName) throws Throwable {
        driver.findElement(By.id(fieldName)).sendKeys(number);
    }

    @And("^I press on the Submit button$")
    public void iPressOnTheSubmitButton() throws Throwable {
        driver.findElement(By.name("submit")).click();
    }

    @And("^I sign in as screener$")
    public void iSignInAsScreener() {
        driver.navigate().to("http://localhost:8080/login");

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "login page"));

        driver.findElement(By.id("username")).sendKeys("screener");
        driver.findElement(By.id("password")).sendKeys("screener");
        driver.findElement(By.name("submit")).click();
    }

    @And("^i go to the ongekeurde panden page$")
    public void iGoToTheOngekeurdePandenPage() {
        new WebDriverWait(driver, 2); //pagina kan varieren, dus kan niet dynamisch
        driver.navigate().to("http://localhost:8080/screener/panden");
    }


    @Then("^I should see a list containing \"([^\"]*)\", \"([^\"]*)\"$")
    public void iShouldSeeAListContaining(String status, String prijs) throws Throwable {
        By bodyByTag = By.tagName("body");
        String newBodyText = driver.findElement(bodyByTag).getText();
        Assert.assertTrue("Did not find price in text: " + prijs + "\n", newBodyText.contains(prijs));
        Assert.assertTrue("Did not find house state in text: " + status + "\n", newBodyText.contains(status));
    }


    @And("^I close the browser$")
    public void iCloseTheBrowser() throws Throwable {
        driver.quit();
    }

}

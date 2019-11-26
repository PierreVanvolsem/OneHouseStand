package com.example.demo;

import com.example.demo.pageobject.AanbodPage;
import com.example.demo.pageobject.LoginPage;
import com.example.demo.pageobject.PandPage;
import com.example.demo.pageobject.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StepdefsPandReserverenPage {
    private WebDriver driver;
    private PandPage pandpage;
    private HomePage homepage;
    private AanbodPage aanbodPage;
    private LoginPage loginPage;
    private static boolean dunit = false;

    /*@Before("@PandReserveren")
    public void setUp() {
        if(!dunit) {
            String pathToGeckoDriver = "C:\\OracleJava\\geckodriver.exe";
            //Setting webdriver.gecko.driver property
            System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
            //Instantiating driver object and launching browser
            driver = new FirefoxDriver();

            //todo clean data
            //create tibo
            driver.navigate().to("http://localhost:8080/");
            driver.findElement(By.id("lijstVanPanden")).click();
            driver.findElement(By.id("createAccount")).click();
            driver.findElement(By.id("username")).sendKeys("tibo");
            driver.findElement(By.id("password")).sendKeys("tibo");
            driver.findElement(By.id("firstName")).sendKeys("tibo");
            driver.findElement(By.id("lastName")).sendKeys("tibo");
            driver.findElement(By.id("email")).sendKeys("tibo@gmail.com");
            driver.findElement(By.name("registreer")).click();

            // login tibo
            driver.findElement(By.id("aanbod")).click();
            driver.findElement(By.id("newPand")).click();
            driver.findElement(By.id("username")).sendKeys("tibo");
            driver.findElement(By.id("password")).sendKeys("tibo");
            driver.findElement(By.name("login")).click();

            // pand aanmaken
            driver.findElement(By.id("huisNummer")).sendKeys("4");
            driver.findElement(By.id("prijsPerUur")).sendKeys("44");
            driver.findElement(By.id("straatNaam")).sendKeys("hoogstraat");
            driver.findElement(By.name("toevoegen")).click();

            homepage = new HomePage(driver);

            dunit = true;
        }
    }

    @After("@PandReserveren")
    public void end(){
        this.driver.quit();
    }

    @Gegeven("^er is een bestaand pand met id (\\d+) die goedgekeurd is en die geen reservering heeft$")
    public void erIsEenBestaandPandMetIdDieGoedgekeurdIsEnDieGeenReserveringHeeft(int arg0) {
        //run script
    }

    @En("^er is een huurder Tibo ingelogd\\.$")
    public void erIsEenHuurderTiboIngelogd() {
        homepage.navigateToHomePage();
        homepage.logout();
        loginPage = homepage.navigateToLoginPage();
        loginPage.login();
    }

    @En("^Tibo is op de pagina van het pand met id (\\d+)$")
    public void tiboIsOpDePaginaVanDePandMetId(int id) {
        pandpage = loginPage.navigateToAanbod(id);
    }

    @Als("^Tibo het veld \"([^\"]*)\" invuld met (\\d+)$")
    public void tiboHetVeldInvuldMet(String elementname, int inhoud) throws Throwable {
        if (elementname == "aantalPersonen")
            pandpage.enterAantalPersonenVanReservatie(inhoud);
    }

    @En("^Tibo het veld \"([^\"]*)\" invuld  met \"([^\"]*)\"$")
    public void tiboHetVeldInvuldMet(String elementid, String inhoud) throws Throwable {
        if (elementid == "einddatum")
            pandpage.enterDatumReservatie(inhoud);
    }

    @Dan("^staat er een nieuwe lijn onder Bestaande reservaties met \"([^\"]*)\"$")
    public void staatErEenNieuweLijnOnderBestaandeReservatiesMet(String reservatie) throws Throwable {
        Assert.assertTrue(pandpage.verifyBestaandereservatie(reservatie));
    }

    @Dan("^staat er op de error pagina \"([^\"]*)\"$")
    public void staatErOpDeErrorPagina(String errorbericht) throws Throwable {
        Assert.assertTrue(pandpage.verifyError(errorbericht));
    }

    @En("^Tibo op reserveer Klikt$")
    public void tiboOpReserveerKlikt() {
        pandpage.reserveer();
    }

    @Gegeven("^het pand met id (\\d+) heeft één reservatie met datum \"([^\"]*)\" en aantal personen (\\d+)$")
    public void hetPandMetIdHeeftÉénReservatieMetDatumEnAantalPersonen(int arg0, String arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
        //todo script
    }*/
}

package com.example.demo;

import com.example.demo.pageobject.AanbodPage;
import com.example.demo.pageobject.HomePage;
import com.example.demo.pageobject.LoginPage;
import com.example.demo.pageobject.PandPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepdefsFlowLayer {
    private WebDriver driver;
    private PandPage pandpage;
    private HomePage homepage;
    private AanbodPage aanbodPage;
    private LoginPage loginPage;

    @Before("@PandReserveren")
    public void setUp() {
        //todo clean data

        String pathToGeckoDriver = "C:\\OracleJava\\geckodriver.exe";
        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.gecko.driver", pathToGeckoDriver );
        //Instantiating driver object and launching browser
        driver = new FirefoxDriver();

        homepage = new HomePage(driver);
    }

    @After("@PandReserveren")
    public void end(){
        this.driver.quit();
    }

    @Gegeven("^er is een bestaand pand die geldig is en die geen reservering heeft$")
    public void erIsEenBestaandPandDieGeldigIsEnDieGeenReserveringHeeft() {
        //todo
    }

    @En("^er is een geldige huurder ingelogd\\.$")
    public void erIsEenGeldigeHuurderIngelogd() {
        homepage.navigateToHomePage();
        homepage.logout();
        loginPage = homepage.navigateToLoginPage();
        loginPage.login();
    }

    @En("^de huurder is op de pagina van het pand$")
    public void deHuurderIsOpDePaginaVanHetPand() {
        pandpage = loginPage.navigateToAanbod(1);
    }

    @Als("^de huurder het veld \"([^\"]*)\" invuld met een geldig aantal$")
    public void deHuurderHetVeldInvuldMetEenGeldigAantal(String arg0) throws Throwable {
        pandpage.enterAantalPersonenVanReservatie(5);
    }

    @En("^de huurder het veld \"([^\"]*)\" invuld  met een geldige datum$")
    public void deHuurderHetVeldInvuldMetEenGeldigeDatum(String arg0) throws Throwable {
        pandpage.enterDatumReservatie("20/11/2020");
    }

    @En("^de huurder op reserveer klikt$")
    public void deHuurderOpReserveerKlikt() {
        pandpage.reserveer();
    }

    @Dan("^kan je de reservatie zien onder reservaties$")
    public void kanJeDeReservatieZienOnderReservaties() {
        pandpage.verifyBestaandereservatie("5 personen 2020-11-20");
    }

    @Als("^de huurder het veld \"([^\"]*)\" invuld met een ongeldig getal$")
    public void deHuurderHetVeldInvuldMetEenOngeldigGetal(String arg0) throws Throwable {
        pandpage.enterAantalPersonenVanReservatie(120);
    }

    @Dan("^staat er op een error bericht$")
    public void staatErOpEenErrorBericht() {
        pandpage.verifyError("");
    }

    @Gegeven("^het pand heeft één reservatie met datum een geldige datum en een geldig aantal personen$")
    public void hetPandHeeftÉénReservatieMetDatumEenGeldigeDatumEnEenGeldigAantalPersonen() {
        //todo
    }

    @Als("^de huurder het veld \"([^\"]*)\" invuld met een geldig getal$")
    public void deHuurderHetVeldInvuldMetEenGeldigGetal(String arg0) throws Throwable {
        pandpage.enterAantalPersonenVanReservatie(5);
    }

    @En("^de huurder het veld \"([^\"]*)\" invuld  met een ongeldige datum$")
    public void deHuurderHetVeldInvuldMetEenOngeldigeDatum(String arg0) throws Throwable {
        pandpage.enterDatumReservatie("20/11/2019");
    }

    @Gegeven("^de geldige pand heeft één geldige reservatie$")
    public void deGeldigePandHeeftÉénGeldigeReservatie() {
        //todo
    }
}

package com.example.demo;

import com.example.demo.pageobject.*;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StepdefsFlowLayer {
    private WebDriver driver;
    private PandPage pandpage;
    private HomePage homepage;
    private AanbodPage aanbodPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Before("@PandReserverenLayered")
    public void setUp() {
        String pathToGeckoDriver = "C:\\Users\\Pierre\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe";
        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.gecko.driver", pathToGeckoDriver );
        //Instantiating driver object and launching browser

        driver = new FirefoxDriver();
        homepage = new HomePage(driver);

        //eigenaar is NULL
        String jdbcUrl = "jdbc:mysql://localhost:3306/ohs4";
        String username = "root";
        String password = "";
        String sqlDeleteUser = "DELETE FROM `users`";
        String sqlDeletePanden = "DELETE FROM `panden`";
        String sqlDeleteReservations = "DELETE FROM `panden_reviews`";

        String sqlAddPand = "INSERT INTO `panden` (`id`, `bron`, `huis_nummer`, `prijs_per_uur`, `status`, `straat_naam`, `eigenaar_id`) VALUES (1, 'bron', '25', '10', 'goedgekeurd', 'stormstraat', NULL);";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement())
        {
            stmt.executeUpdate(sqlDeleteUser);
            stmt.executeUpdate(sqlDeletePanden);
            stmt.executeUpdate(sqlDeleteReservations);
            stmt.executeUpdate(sqlAddPand);
            System.out.println("Database updated successfully");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @After("@PandReserverenLayered")
    public void end(){
        homepage.closeBrowser();
    }

    @Gegeven("^er is een bestaand pand die geldig is en die geen reservering heeft$")
    public void erIsEenBestaandPandDieGeldigIsEnDieGeenReserveringHeeft() {
        registerPage = homepage.navigateToRegisterPage();
        loginPage = registerPage.CreateUserTibo();

        //login tibo
        loginPage.login();
    }

    @En("^er is een geldige huurder ingelogd\\.$")
    public void erIsEenGeldigeHuurderIngelogd() {
        //homepage.logout();
        //homepage.navigateToHomePage();
        //homepage.logout();
        //loginPage = homepage.navigateToLoginPage();
        //loginPage.login();
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
        String jdbcUrl = "jdbc:mysql://localhost:3306/ohs4";
        String username = "root";
        String password = "";

        String sqlCreateReservation = "INSERT INTO `reservaties` (`id`, `aantal_personen`, `eind_datum`) VALUES (1, '5', '20-11-2020');";
        String sqlAddReservationtonPand  = "INSERT INTO `panden_reservaties` (`pand_id`, `reservaties_id`) VALUES ('1', '1');";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement())
        {
            stmt.executeUpdate(sqlCreateReservation);
            stmt.executeUpdate(sqlAddReservationtonPand);
            System.out.println("Database updated successfully");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}

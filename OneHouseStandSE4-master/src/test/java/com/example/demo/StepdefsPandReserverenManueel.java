package com.example.demo;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class StepdefsPandReserverenManueel {
    private WebDriver driver;
    private static boolean dunit = false;

    @Before("@PandReserveren")
    public void setUp() {
        //if(!dunit) {
            String pathToGeckoDriver = "C:\\Users\\Pierre\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe";
            //Setting webdriver.gecko.driver property
            System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
            //Instantiating driver object and launching browser
            driver = new FirefoxDriver();

            //todo clean data
            //create tibo
            driver.navigate().to("http://localhost:8080/registreer");
            driver.findElement(By.id("username")).sendKeys("tibo");
            driver.findElement(By.id("password")).sendKeys("tibo");
            driver.findElement(By.id("firstName")).sendKeys("tibo");
            driver.findElement(By.id("lastName")).sendKeys("tibo");
            driver.findElement(By.id("email")).sendKeys("tibo@gmail.com");
            driver.findElement(By.name("registreer")).click();

            // login tibo
            driver.navigate().to("http://localhost:8080/login");
            driver.findElement(By.id("username")).sendKeys("tibo");
            driver.findElement(By.id("password")).sendKeys("tibo");
            driver.findElement(By.name("login")).click();

            // pand aanmaken
            /*driver.findElement(By.id("huisNummer")).sendKeys("4");
            driver.findElement(By.id("prijsPerUur")).sendKeys("44");
            driver.findElement(By.id("straatNaam")).sendKeys("hoogstraat");
            driver.findElement(By.name("toevoegen")).click();*/

            //create pand
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
                stmt.executeUpdate(sqlDeleteUser);
                System.out.println("Database updated successfully");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

            //dunit = true;
        //}
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
        driver.navigate().to("http://localhost:8080/");
        driver.findElement(By.name("logout")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Je bent uitgelogd"));
        driver.navigate().to("http://localhost:8080/login");
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "login page"));
        driver.findElement(By.id("username")).sendKeys("tibo");
        driver.findElement(By.id("password")).sendKeys("tibo");
        driver.findElement(By.name("login")).click();
        new WebDriverWait(driver, 2); //pagina kan varieren, dus kan niet dynamisch
    }

    @En("^Tibo is op de pagina van het pand met id (\\d+)$")
    public void tiboIsOpDePaginaVanDePandMetId(int id) {
        driver.navigate().to("http://localhost:8080/pand?id="+id);
    }

    @Als("^Tibo het veld \"([^\"]*)\" invuld met (\\d+)$")
    public void tiboHetVeldInvuldMet(String elementname, int inhoud) throws Throwable {
        driver.findElement(By.name(elementname)).sendKeys(Integer.toString(inhoud));
    }

    @En("^Tibo het veld \"([^\"]*)\" invuld  met \"([^\"]*)\"$")
    public void tiboHetVeldInvuldMet(String elementid, String inhoud) throws Throwable {
        String[] parts = inhoud.split("/");
        inhoud = parts[2] +"-"+parts[1]+"-"+parts[0];
        driver.findElement(By.id(elementid)).click();
        driver.findElement(By.id(elementid)).sendKeys(inhoud);
    }

    @Dan("^staat er een nieuwe lijn onder Bestaande reservaties met \"([^\"]*)\"$")
    public void staatErEenNieuweLijnOnderBestaandeReservatiesMet(String reservatie) throws Throwable {
        String bodytext = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodytext.contains(reservatie));
    }

    @Dan("^staat er op de error pagina \"([^\"]*)\"$")
    public void staatErOpDeErrorPagina(String errorbericht) throws Throwable {
        String bodytext = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodytext.contains(errorbericht));
    }

    @En("^Tibo op reserveer Klikt$")
    public void tiboOpReserveerKlikt() {
        driver.findElement(By.name("submit")).click();
    }

    @Gegeven("^het pand met id (\\d+) heeft één reservatie met datum \"([^\"]*)\" en aantal personen (\\d+)$")
    public void hetPandMetIdHeeftÉénReservatieMetDatumEnAantalPersonen(int arg0, String arg1, int arg2) throws Throwable {
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

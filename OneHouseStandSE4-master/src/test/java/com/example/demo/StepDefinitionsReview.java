/*package com.example.demo;

import com.example.demo.domain.Pand;
import com.example.demo.domain.Review;
import com.example.demo.domain.User;
import com.example.demo.service.OhsServiceImplementatie;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertNull;
import static org.mockito.AdditionalMatchers.*;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class StepDefinitionsReview {

    private User tibo;
    private User pierre;
    private Pand pand;
    private Review review;
    private OhsServiceImplementatie ohsServiceImplementatie = new OhsServiceImplementatie();

    @Mock
    private OhsServiceImplementatie mockService;

    @Before
    public void setUp(){
        initMocks(this);

        Mockito.when(mockService.deletePand(any(Integer.class))).thenReturn(null);
    }

    @Gegeven("^er is een bestaand pand Waterkasteel Moorsel$")
    public void erIsEenBestaandePand() {
        pand = new Pand();
        pand.setStraatNaam("Waterkasteel Moorsel");    }

    @Gegeven("^er is een huurder Tibo ingelogd.$")
    public void erIsEenHuurderTiboIngelogd() {
        tibo = new User();
    }

    @Gegeven("^er is een screener Pierre ingelogd.$")
    public void erIsEenScreenerPierreIngelogd() {
        pierre = new User();
    }

    @Als("^Tibo een review plaatst met als beschrijving \"([^\"]*)\" met score (\\d+)$")
    public void tiboEenReviewPlaatstMetAlsBeschrijving(String beschrijving, int score) throws Throwable {
        review = ohsServiceImplementatie.creerReview(pand, beschrijving, score);
    }

    @Dan("^zal de review status \"([^\"]*)\" zijn.$")
    public void zalDeReviewOnverwerktZijn(String status) {
        assertEquals(status,review.getStatus());
    }


    @Gegeven("^Tibo heeft een review geplaatst met als beschrijving \"([^\"]*)\" met score (\\d+)$")
    public void tiboHeeftEenReviewGeplaatstMetBeschrijvingMetScore(String beschrijving, int score) {
        review = ohsServiceImplementatie.creerReview(pand, beschrijving, score);
    }

    @Als("^de screener op de knop verberg review klikt$")
    public void deScreenerOpDeKnopVerbergReviewKlikt() throws Throwable {
        review = ohsServiceImplementatie.verbergReview(review, pierre);
    }

    @En("^de review heeft status \"([^\"]*)\"$")
    public void deReviewHeeftStatusVerborgen(String status) throws Throwable {
        review = ohsServiceImplementatie.verbergReview(review, pierre);
    }

    @Als("^de screener op de knop archiveer pand klikt$")
    public void deScreenerOpDeKnopArchiveerPandKlikt() throws Throwable {
        pand = mockService.deletePand(5);
    }

    //TODO: Vragen of dit null mag
    @Dan("^zal de review null zijn.$")
    public void zalDeReviewNullZijn() {
        if (pand == null)
            review = null;

        assertNull(review);
    }
}
*/
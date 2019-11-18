package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.service.OhsServiceImplementatie;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;

public class StepDefinitionsPandReviewSts {

    //TODO screener pierre en klant tibo zijn wel aangemaakt, het is wel gegeven dat die er moeten zijn...
    //maar deze zijn eigenlijk niet nuttig in deze context, aangezien de service klasse hun niet gebruikt voor het checken.
    //Dit gebeurt via de UI (knop al dan niet beschikbaar).
    //Kunnen wij tibo en pierre beter weglaten?
    private User tibo;
    private User pierre;
    private Pand pand;
    private Review review;
    private OhsServiceImplementatie ohsServiceImplementatie = new OhsServiceImplementatie();

    @Mock
    private OhsServiceImplementatie mockService;

    @Before
    public void setUp() {
        initMocks(this);

        Mockito.when(mockService.deletePand(any(Integer.class))).thenReturn(null);
    }

    //
    @Gegeven("^er is een bestaand pand$")
    public void er_is_een_bestaand_pand() {
        pand = new Pand();
    }

    @Gegeven("^er is een klant Tibo ingelogd$")
    public void er_is_een_huurder_Tibo_ingelogd() {
        tibo = new User();
        tibo.setRole("KLANT");
    }

    @Gegeven("^er is een screener Pierre ingelogd$")
    public void er_is_een_screener_Pierre_ingelogd() {
        pierre = new User();
        pierre.setRole("SCREENER");
    }

    @Als("^Tibo een review plaatst met als beschrijving \"([^\"]*)\" met score (\\d+)$")
    public void tibo_een_review_plaats_met_beschrijving_en_score(String beschrijving, int score) throws Throwable {
        review = ohsServiceImplementatie.creerReview(pand, tibo, beschrijving, score);
    }

    @Dan("^(?:zal|zou) de review status \"([^\"]*)\"(?: moeten)? zijn$")
    public void zal_de_review_status_zijn(String status) {
        assertEquals(status,review.getStatus());
    }

    @Als("^de status van de review is \"([^\"]*)\"$")
    public void de_status_van_de_review_is(String status) {
        assertEquals(status,review.getStatus());
    }

    @Als("^Pierre verwerkt de review$")
    public void pierre_verwerkt_de_review() {
        ohsServiceImplementatie.verwerkReview(review, pierre);
    }

    @Als("^Pierre verbergt de review$")
    public void pierre_verbergt_de_review() {
        ohsServiceImplementatie.verbergReview(review, pierre);
    }

    @Als("^het pand waaraan de review gekoppeld is wordt verwijdert$")
    public void het_pand_gekoppeld_aan_review_wordt_verwijdert() {
        pand = mockService.deletePand(3);
        if (pand == null)
            review = null; //TODO Mag dit?
    }

    @Dan("^zou de review niet meer mogen bestaan$")
    public void zou_de_review_niet_meer_mogen_bestaan() {
        assertNull(review);
    }
}

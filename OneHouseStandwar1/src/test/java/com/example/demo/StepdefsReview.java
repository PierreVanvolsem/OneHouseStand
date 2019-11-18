package com.example.demo;

import com.example.demo.domain.Huurder;
import com.example.demo.domain.Pand;
import com.example.demo.domain.Review;
import com.example.demo.domain.User;
import com.example.demo.service.OhsServiceImplementatie;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class StepdefsReview {
/*
    private  User tibo;
    private Pand pand;
    private Review review;
    private OhsServiceImplementatie ohsServiceImplementatie;

    @Before
    public void setUp()
    {
        Review reviewverwerkt = new Review();
        reviewverwerkt.setStatus("Verwerkt");
        Review reviewverborgen = new Review();
        reviewverborgen.setStatus("Verborgen");
        ohsServiceImplementatie = mock(OhsServiceImplementatie.class);
        // todo reviewverwerkt             conent , title, datum, user toevoegen ?
        Mockito.when(ohsServiceImplementatie.processReview(Mockito.any(Review.class),Mockito.anyLong(),Mockito.any(User.class))).thenReturn(reviewverwerkt);
        Mockito.when(ohsServiceImplementatie.verbergReview(Mockito.any(Review.class),Mockito.any(User.class))).thenReturn(reviewverborgen);

    }

    @Gegeven("^er is een bestaande pand$")
    public void erIsEenBestaandePand() {
        pand = new Pand();
    }

    @En("^er is een huurder Tibo ingelogd\\.$")
    public void erIsEenHuurderTiboIngelogd() {
        tibo = new User();
    }

    @Als("^Tibo een review plaatst met als beschrijving \"([^\"]*)\"$")
    public void tiboEenReviewPlaatstMetAlsBeschrijving(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        review = new Review();
        Date now = new Date();
        review.setDatum(now.toString());
        review.setGebruiker(tibo);
        review.setPand(pand);
        review.setContent(arg0);
    }

    @En("^de score van de review is (\\d+)$")
    public void deScoreVanDeReviewIs(int arg0) {
        review.setRating(arg0);
    }

    @En("^het systeem verwerkt de review$")
    public void hetSysteemVerwerktDeReview() {
        review = ohsServiceImplementatie.processReview(review,pand.getId(),tibo);
    }

    @En("^het systeem beschouwt de review als verwerkt$")
    public void hetSysteemBeschouwtDeReviewAlsVerwerkt() {

    }

    @En("^de screener verbergt de review$")
    public void deScreenerVerbergtDeReview() {
        review = ohsServiceImplementatie.verbergReview(review,tibo);
    }

    @En("^de pand van de review wordt gearchiveerd\\.$")
    public void dePandVanDeReviewWordtGearchiveerd() {

    }

    @Dan("^zal de verwerkte review final zijn\\.$")
    public void zalDeVerwerkteReviewFinalZijn() {
        //todo make final
        assertEquals("Verborgen",review.getStatus());
    }*/
}

package domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Glenn
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
@Component("huurder")
public class Huurder implements Klant {
    private List<Review> geschrevenReviews;
    private List<Reservatie> reservaties;
    private String naam = "Bob - Huurder Origineel";

    public Huurder() {

    }

    @Autowired
    public void setNaam(String setHuurderNaam) {
        this.naam = setHuurderNaam;
    }

    public String getNaam() {
        return naam;
    }
}
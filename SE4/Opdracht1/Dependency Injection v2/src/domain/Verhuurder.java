package domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Fabian
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
@Component("verhuurder")
public class Verhuurder implements Klant {

    private List<Pand> panden;

    public Verhuurder() {

    }

    private String naam;
    
    @Autowired
    public void setNaam(String setVerhuurderNaam) {
        this.naam = setVerhuurderNaam;
    }

    public String getNaam() {
        return naam;
    }
}//end Verhuurder
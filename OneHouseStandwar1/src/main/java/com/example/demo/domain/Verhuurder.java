package com.example.demo.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @author Fabian
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
@Entity
@Table(name = "VERHUURDERS")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Verhuurder implements Klant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;


//    private List<Pand> panden;
//
    private String naam;

    public void setNaam(String setVerhuurderNaam) {
        this.naam = setVerhuurderNaam;
    }

    public String getNaam() {
        return naam;
    }
}//end Verhuurder
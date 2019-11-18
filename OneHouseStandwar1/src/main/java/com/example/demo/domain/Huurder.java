package com.example.demo.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @author Glenn
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
@Entity
@Table(name = "HUURDERS")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
public abstract class Huurder implements Klant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long id;
//
//    private List<Review> geschrevenReviews;
//    private List<Reservatie> reservaties;
    private String naam = "Bob - Huurder Origineel";

}
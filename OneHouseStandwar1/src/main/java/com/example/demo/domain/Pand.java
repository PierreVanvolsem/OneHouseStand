package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PANDEN")
@Data
@XmlRootElement(name = "pand")
@NoArgsConstructor(force = true)
public class Pand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    private String bron;

    @NotBlank(message = "Huisnummer is vereist.")
    private String huisNummer;

    @Range(min = 0L, message = "Prijs per uur moet een positief getal zijn.")
    @NotNull(message = "Prijs per uur is vereist.")
    private Double prijsPerUur;

    private String status;

    @NotBlank(message = "Straatnaam is vereist.")
    private String straatNaam;

    @ManyToOne
    private User eigenaar;

    @OneToMany
    private List<Mat> matten;

    @OneToMany
    private List<Reservatie> reservaties;

    @OneToMany
    @JsonManagedReference
    private List<Review> reviews = new ArrayList<>();

    public void keurAf() {

    }

    public void keurGoed() {

    }

    /**
     * @param huurder        huurder van her huis
     * @param begindatum     begin van de reservatiepriode
     * @param einddatum      einde van de reservatieperiode
     * @param aantalPersonen het aantal personen die in het pand zullen verblijven
     */
    public Reservatie reserveer(Huurder huurder, Date begindatum, Date einddatum, int aantalPersonen) {
        return null;
    }

    /**
     *
     */
    public void reserveer(Reservatie reservatie) {
        if (reservatie != null)
            reservaties.add(reservatie);
    }

    public void review(Review r) {
        if (r != null)
            reviews.add(r);
    }

    public Review voegReviewToe(String beschrijving, int score) {
        Review review = new Review();
        review.setContent(beschrijving);
        review.setRating(score);

        this.reviews.add(review);
        return review;
    }

    /**
     * @param m de mat die geupdate wordt
     */
    public void updateMat(Mat m) {

    }

    /**
     * @param m de mat die verwijderd wordt
     */
    public void verwijderMat(Mat m) {
        matten.remove(m);
    }

    /**
     * @param mat de mat die toegevoegd wordt
     */
    public void voegMatToe(Mat mat) {
        matten.add(mat);

    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Reservatie> getReservaties() {
        return reservaties;
    }

    public void setReservaties(List<Reservatie> reserv) {
        reservaties = reserv;
    }

    @XmlElement(name = "status")
    public String getStatus() {
        return status;
    }

    @XmlElement(name = "bron")
    public String getBron() {
        return bron;
    }

    public void setBron(String bron) {
        this.bron = bron;
    }

    @XmlElement(name = "huisnummer")
    public String getHuisNummer() {
        return huisNummer;
    }

    public void setHuisNummer(String huisNummer) {
        this.huisNummer = huisNummer;
    }

    @XmlElement(name = "prijsperuur")
    public Double getPrijsPerUur() {
        return prijsPerUur;
    }

    public void setPrijsPerUur(Double prijsPerUur) {
        this.prijsPerUur = prijsPerUur;
    }

    @XmlElement(name = "straatnaam")
    public String getStraatNaam() {
        return straatNaam;
    }

    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

    public List<Mat> getMatten() {
        return matten;
    }

    public void setMatten(List<Mat> matten) {
        this.matten = matten;
    }

    @XmlElement(name = "eigenaar")
    public User getEigenaar() {
        return eigenaar;
    }

    public void setEigenaar(User v) {
        eigenaar = v;
    }

    public void matToevoegen(Mat mat) {
        matten.add(mat);
    }

    public void matVerwijderen(Mat m) {
        matten.remove(m);
    }

}

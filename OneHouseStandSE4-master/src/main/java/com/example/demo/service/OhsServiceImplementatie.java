package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.domain.*;
import com.example.demo.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author trelu
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
@Slf4j
@Service
public class OhsServiceImplementatie implements OhsService {

    @Autowired
    private PandRepository pandRepository;

    @Autowired
    private MatRepository matRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @Autowired
    private ReservatieRepository reservatieRepository;


    @Override
    public Iterable<Pand> geefAllePanden() {
        return pandRepository.findAll();
    }

    @Override
    public Pand geefPand(int id) {
        return pandRepository.findById(id);
    }

    public Iterable<Pand> geefAlleGoedgekeurdePanden() {
        Iterable<Pand> allepanden = geefAllePanden();
        ArrayList<Pand> goedGekeurdePanden = new ArrayList<Pand>();

        for (Pand p : allepanden) {
            if (p.getStatus().trim().equalsIgnoreCase("goedgekeurd")) {
                goedGekeurdePanden.add(p);
            }
        }
        return goedGekeurdePanden;
    }

    @Override
    public Mat addMat(Mat mat) {
        matRepository.save(mat);
        return mat;
    }

    @Override
    public Pand addPand(Pand pand, User eigenaar) {

        pand.setStatus("ongekeurd");
        pand.setBron("ohs");
        pand.setMatten(new ArrayList<Mat>());
        pand.setEigenaar(eigenaar);
        pandRepository.save(pand);
        return pand;
    }

    @Override
    public Pand editPand(Pand pand, long id) {
        Pand outdatedPand = pandRepository.findById(id);
        outdatedPand.setStatus(pand.getStatus());
        outdatedPand.setBron(pand.getBron());
        outdatedPand.setHuisNummer(pand.getHuisNummer());
        outdatedPand.setPrijsPerUur(pand.getPrijsPerUur());
        outdatedPand.setStraatNaam(pand.getStraatNaam());
        outdatedPand.setReservaties(pand.getReservaties());
        pandRepository.save(outdatedPand);
        return outdatedPand;
    }

    @Override
    public Mat herstelMat(Mat mat) {
        mat.herstel();
        return matRepository.save(mat);
    }

    @Override
    public Mat zetMatAlsVersleten(Mat mat) {
        mat.markeerAlsVersleten();
        return matRepository.save(mat);
    }
/*
    @Override
    public Mat editMat(Mat mat) {
        Mat outdatedMat = matRepository.findById(mat.getId());
        outdatedMat.setStatus(mat.getStatus());
        outdatedMat.setLaatstGecheckt(mat.getLaatstGecheckt());
        outdatedMat.setAankoopPrijs(mat.getAankoopPrijs());
        outdatedMat.setProductNummer(mat.getProductNummer());
        matRepository.save(outdatedMat);
        return outdatedMat;
    }*/

    @Override
    public Iterable<Mat> geefAlleMatten() {
        return matRepository.findAll();
    }

    @Override
    public Reservatie reserveer(Date startdatum, Date einddatum, Huurder huurder, Pand pand, int aantalPersonen) {
        return null;
    }

    @Override
    public Reservatie addReservatie(Reservatie reservatie) {
        reservatieRepository.save(reservatie);
        return reservatie;
    }


    @Override
    public void verwerkPand(Pand pand, String oordeel) {

    }

    @Override
    public Review verwerkReview(Review review) {
        return null;
    }

    @Override
    public void deletePand(Long id) {
        //Pand p = pandRepository.findById(id);
        pandRepository.deleteById(id);
    }

    @Override
    public Pand updateStatusPand(long id) {
        Pand pand = pandRepository.findById(id);
        pand.setStatus("gekeurd");
        return pandRepository.save(pand);
    }

    @Override
    public Mat geefMat(int id) {
        return matRepository.findById(id);
    }


    @Override
    public Reservatie processReservatie(Reservatie r, long pandId) {
        addReservatie(r);
        Pand pand = geefPand((int) pandId);
        pand.reserveer(r);
        pandRepository.save(pand);
        return r;
    }

    @Override //TODO: add pand to review
    public Review processReview(Review r, long pandId, User u) {
        Pand pand = geefPand((int) pandId);

        r.setPand(pand);
        r.setGebruiker(u);
        r.setDatum(java.sql.Date.valueOf(LocalDate.now()).toString());

        reviewRepository.save(r);
        pand.review(r);
        pandRepository.save(pand);
        return r;
    }

    public Mat editMat(Mat mat) {
        matRepository.save(mat);
        return mat;
    }

    @Override
    public Iterable<Review> getReviewsPandById(long id) {
        List<Review> reviews = toList(reviewRepository.findAll());

        for (Review review : reviews) {
            if (review.getPand().getId() != id) {
                reviews.remove(review);
            }
        }
        return reviews;
    }

    @Override
    public void verwerkMatToevoegen(Mat mat, Pand pand) {
        mat.herstel();

        assert pand != null;
        pand.voegMatToe(mat);

        addMat(mat);
        editPand(pand, pand.getId());
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

}//end OhsServiceImplementatie

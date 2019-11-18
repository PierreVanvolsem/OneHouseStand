package com.example.demo.service;


import com.example.demo.domain.*;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author trelu
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
public interface OhsService {
    Iterable<Pand> geefAllePanden();

    Iterable<Pand> geefAlleGoedgekeurdePanden();

    Reservatie addReservatie(Reservatie reservatie);

    Mat addMat(Mat mat);

    Iterable<Mat> geefAlleMatten();

    Pand addPand(Pand pand, User eigenaar);

    Mat herstelMat(Mat mat);

    Mat zetMatAlsVersleten(Mat mat);

    Mat editMat(Mat mat);

    Reservatie reserveer(Date startdatum, Date einddatum, Huurder huurder, Pand pand, int aantalPersonen);

    void verwerkPand(Pand pand, String oordeel);

    Review verwerkReview(Review review);

    Pand deletePand(long id);

    Pand updateStatusPand(long id);

    Pand editPand(Pand pand, long id);

    Pand geefPand(int id);

    Mat geefMat(int id);

    Reservatie processReservatie(Reservatie r, long pandId);

    Review processReview(Review r, long pandId, User u);

    Iterable<Review> getReviewsPandById(long id);
    void verwerkMatToevoegen(Mat m, Pand p);

    Review creerReview(Pand pand, String beschrijving, int score);
    Review creerReview(Pand pand, User user, String beschrijving, int score);
    Review verbergReview(Review review, User user);
    Review verwerkReview(Review review, User user);
}
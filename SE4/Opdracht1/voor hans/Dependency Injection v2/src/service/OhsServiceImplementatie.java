package service;
import domain.*;

import java.sql.Date;

/**
 * @author trelu
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
public class OhsServiceImplementatie implements OhsService {

    public Verhuurder m_Verhuurder;

    public OhsServiceImplementatie() {

    }

    /**
     * @param aankoopprijs
     * @param laatstGecheckt
     * @param productNummer
     * @param status
     */
    public Mat addMat(Double aankoopprijs, java.util.Date laatstGecheckt, int productNummer, String status) {
        return null;
    }

    /**
     * @param bron
     * @param eigenaar
     * @param huisNummer
     * @param prijsPerUur
     * @param status
     * @param straatNaam
     */
    public Pand addPand(String bron, Verhuurder eigenaar, String huisNummer, Double prijsPerUur, String status, String straatNaam) {
        return null;
    }


    /**
     * @param pand
     * @param huurder
     * @param content
     * @param datum
     * @param rating
     */
    public Review addReview(Pand pand, Huurder huurder, String content, java.util.Date datum, int rating) {
        return null;
    }

    /**
     * @param mat
     */
    public Mat herstelMat(Mat mat) {
        return null;
    }


    /**
     * @param startdatum
     * @param einddatum
     * @param huurder
     * @param pand
     * @param aantalPersonen
     */
    public Reservatie reserveer(java.util.Date startdatum, java.util.Date einddatum, Huurder huurder, Pand pand, int aantalPersonen) {
        return null;
    }

    /**
     * @param pand
     * @param oordeel
     */
    public void verwerkPand(Pand pand, String oordeel) {

    }

    /**
     * @param review
     */
    public Review verwerkReview(Review review) {
        return null;
    }
}//end OhsServiceImplementatie
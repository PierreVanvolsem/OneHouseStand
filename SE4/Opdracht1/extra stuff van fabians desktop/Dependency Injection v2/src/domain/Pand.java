package domain;


import java.util.Date;

/**
 * @author Fabian
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
public class Pand {

    private String bron;
    private Verhuurder eigenaar;
    private String huisNummer;
    private Mat matten;
    private Double prijsPerUur;
    private Reservatie reservaties;
    private String status;
    private String straatNaam;
    public Verhuurder m_Verhuurder;
    public Mat m_Mat;

    public Pand() {

    }


    public void keurAf() {

    }

    public void keurGoed() {

    }

    /**
     * @param huurder
     * @param begindatum
     * @param einddatum
     * @param aantalPersonen
     */
    public Reservatie reserveer(Huurder huurder, Date begindatum, Date einddatum, int aantalPersonen) {
        return null;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {

    }

    /**
     * @param m
     */
    public void updateMat(Mat m) {

    }

    /**
     * @param m
     */
    public void verwijderMat(Mat m) {

    }

    /**
     * @param mat
     */
    public void voegMatToe(Mat mat) {

    }
}//end Pand
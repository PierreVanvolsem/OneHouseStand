package service;


import domain.*;

import java.util.Date;

/**
 * @author trelu
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
public interface OhsService {

	/**
	 * 
	 * @param aankoopprijs
	 * @param laatstGecheckt
	 * @param productNummer
	 * @param status
	 */
	public Mat addMat(Double aankoopprijs, Date laatstGecheckt, int productNummer, String status);

	/**
	 * 
	 * @param bron
	 * @param eigenaar
	 * @param huisNummer
	 * @param prijsPerUur
	 * @param status
	 * @param straatNaam
	 */
	public Pand addPand(String bron, Verhuurder eigenaar, String huisNummer, Double prijsPerUur, String status, String straatNaam);

	/**
	 * 
	 * @param pand
	 * @param huurder
	 * @param content
	 * @param datum
	 * @param rating
	 */
	public Review addReview(Pand pand, Huurder huurder, String content, Date datum, int rating);

	/**
	 * 
	 * @param mat
	 */
	public Mat herstelMat(Mat mat);

	/**
	 * 
	 * @param startdatum
	 * @param einddatum
	 * @param huurder
	 * @param pand
	 * @param aantalPersonen
	 */
	public Reservatie reserveer(Date startdatum, Date einddatum, Huurder huurder, Pand pand, int aantalPersonen);

	/**
	 * 
	 * @param pand
	 * @param oordeel
	 */
	public void verwerkPand(Pand pand, String oordeel);

	/**
	 * 
	 * @param review
	 */
	public Review verwerkReview(Review review);

}
package domain;


import java.util.Date;
import java.util.List;

/**
 * @author Fabian
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
public class Review {

	private String content;
	private Date datum;
	private Huurder gebruiker;
	private Boolean isVerborgen;
	private Boolean isVerwerkt;
	private Pand pand;
	private int rating;
	public static List<Review> reviews;
	public Pand m_Pand;
	public Huurder m_Huurder;

	public Review(){

	}

	public void verberg(){

	}

	public void verwerk(){

	}
}//end Review
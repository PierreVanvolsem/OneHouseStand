package domain;


import java.util.Date;

/**
 * @author Fabian
 * @version 1.0
 * @created 15-Mar-2019 18:40:44
 */
public class Reservatie {

	private int aantalPersonen;
	private Date eindDatum;
	private Huurder huurder;
	private Pand pand;
	private Double prijs;
	private Date startDatum;
	public Huurder m_Huurder;
	public Pand m_Pand;

	public Reservatie(){

	}


}//end Reservatie
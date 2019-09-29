package be.hubrussel.service;


import be.hubrussel.domain.*;

import java.util.Date;
import java.util.List;

/**
 * @author trelu
 * @version 1.0
 * @created 05-mars-2019 10:07:27
 */
public interface OhsService {



	public Mat voegMatToe(Double aankoopprijs, Date laatstGecheckt, String status, int productNummer);
	public Mat zoekMat (int id);
	public Mat bewerkMat(Mat m);

//	public void schrijfOver (Rekening vanRekening, Rekening naarRekening, double bedrag);

}
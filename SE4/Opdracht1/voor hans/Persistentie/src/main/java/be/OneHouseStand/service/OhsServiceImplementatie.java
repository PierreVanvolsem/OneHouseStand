package be.OneHouseStand.service;


import be.OneHouseStand.dao.MatDao;
import be.OneHouseStand.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author aa
 * @version 1.0
 * @created 05-mars-2019 10:06:05
 */
@Service("ohsService")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class OhsServiceImplementatie implements OhsService {

	private MatDao matDao;

	@Autowired
	public  void setMatDao(MatDao m) {
		this.matDao = m;
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Mat voegMatToe(Double aankoopprijs, Date laatstGecheckt, String status, int productNummer) {
		Mat niewueMat = new Mat(aankoopprijs, laatstGecheckt, status, productNummer);
		return matDao.addMat(niewueMat);
	}

	@Override
	public Mat zoekMat(int id) {
		return matDao.getMatById(id);
	}

	@Override
	public Mat bewerkMat(Mat m) {
		matDao.updateMat(m);
		return m;
	}
}
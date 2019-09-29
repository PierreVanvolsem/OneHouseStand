package be.OneHouseStand.dao;

import be.OneHouseStand.domain.Mat;

public interface MatDao {
    public Mat addMat(Mat m);
    public void updateMat(Mat m);
    public Mat getMatById(int id);
}

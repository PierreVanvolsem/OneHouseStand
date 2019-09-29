package be.hubrussel.dao;

import be.hubrussel.domain.Mat;

public interface MatDao {
    public Mat addMat(Mat m);
    public void updateMat(Mat m);
    public Mat getMatById(int id);
}

package com.example.demo.dao;

import com.example.demo.domain.Mat;
import org.springframework.data.repository.CrudRepository;

public interface MatRepository extends CrudRepository<Mat, Long> {

    public Mat findById(long id);


}

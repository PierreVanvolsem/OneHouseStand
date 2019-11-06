package com.example.demo.dao;

import com.example.demo.domain.Mat;
import com.example.demo.domain.Pand;
import com.example.demo.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    public Review findById(long id);
    Iterable<Review> findByPand(long pandId);

}

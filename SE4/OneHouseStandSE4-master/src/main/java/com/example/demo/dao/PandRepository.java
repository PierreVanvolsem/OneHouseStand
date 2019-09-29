package com.example.demo.dao;

import com.example.demo.domain.Pand;
import org.springframework.data.repository.CrudRepository;

public interface PandRepository extends CrudRepository<Pand, Long> {

    public Pand findById(long id);


}

package com.example.demo.dao;

import com.example.demo.domain.Pand;
import com.example.demo.domain.Reservatie;
import org.springframework.data.repository.CrudRepository;

public interface ReservatieRepository extends CrudRepository<Reservatie, Long> {

}

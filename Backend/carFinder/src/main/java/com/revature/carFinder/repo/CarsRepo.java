package com.revature.carFinder.repo;

import com.revature.carFinder.models.Cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepo extends JpaRepository<Cars, Integer>{
  
}

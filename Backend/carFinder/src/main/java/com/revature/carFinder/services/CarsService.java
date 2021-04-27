package com.revature.carFinder.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.revature.carFinder.models.Cars;
import com.revature.carFinder.repo.CarsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarsService {

  @Autowired
  private CarsRepo carsRepo;

    public ResponseEntity<List<Cars>> getAllCars() {
    return ResponseEntity.ok(carsRepo.findAll());
  }
  
  public ResponseEntity<Cars> getCarById(int id) {
    Optional<Cars> cars = carsRepo.findById(id);
    if(cars.isPresent()) {
      //ToDo: log
      return ResponseEntity.ok(cars.get());
    }
      //ToDo: log
    return ResponseEntity.badRequest().build();
  }

  public ResponseEntity<Cars> createCar(Cars cars) {
    Cars savedCars = carsRepo.save(cars);
    String location = String.format("/api/cars/%s", savedCars.getId());
    //ToDo: log
    return ResponseEntity.created(URI.create(location)).body(savedCars);
  }
  
  public ResponseEntity<Cars> updateCarById(int id, Cars newCars) {
    Optional<Cars> cars = carsRepo.findById(id);
    if (cars.isPresent()) {
      newCars.setId(id);
      carsRepo.save(newCars);
      //ToDo: log
      return ResponseEntity.ok(cars.get());
    }
    //ToDo: log
    return ResponseEntity.badRequest().build();
  }

  public ResponseEntity<Cars> deleteCarById(int id){
    Optional<Cars> cars = carsRepo.findById(id);
    if (cars.isPresent()) {
      carsRepo.deleteById(id);
      //ToDo: log
      return ResponseEntity.noContent().build();
    }
    //ToDo: log
    return ResponseEntity.badRequest().build();
  }


  
}

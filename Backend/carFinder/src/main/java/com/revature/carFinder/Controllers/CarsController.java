package com.revature.carFinder.Controllers;

import java.util.List;

import com.revature.carFinder.models.Cars;
import com.revature.carFinder.services.CarsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CarsController {

  @Autowired
  private CarsService carsService;

  @GetMapping("")
  public ResponseEntity<List<Cars>> getAllCars(){
    return carsService.getAllCars();
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<Cars> getCarById(@PathVariable("id") int id){
    return carsService.getCarById(id);
  }
  @PostMapping("")
  public ResponseEntity<Cars> createCar(@RequestBody Cars cars){
    return carsService.createCar(cars);
  }
  
  @PutMapping("id/{id}")
  public ResponseEntity<Cars> updateCar(@PathVariable("id") int id, @RequestBody Cars cars) {
    return carsService.updateCarById(id, cars);
  }

  @DeleteMapping("id/{id}")
  public ResponseEntity<Cars> deleteCar(@PathVariable("id") int id) {
    return carsService.deleteCarById(id);
  }
  
}

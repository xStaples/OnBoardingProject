package com.revature.carFinder.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.revature.carFinder.models.UserTier;
import com.revature.carFinder.repo.UserTierRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserTierService {

  @Autowired
  private UserTierRepo userTierRepo;

  public ResponseEntity<List<UserTier>> getAllUserTiers() {
    return ResponseEntity.ok(userTierRepo.findAll());
  }
  
  public ResponseEntity<UserTier> getUserTierById(int id) {
    Optional<UserTier> userTier = userTierRepo.findById(id);
    if(userTier.isPresent()) {
      //ToDo: log
      return ResponseEntity.ok(userTier.get());
    }
      //ToDo: log
    return ResponseEntity.badRequest().build();
  }

  public ResponseEntity<UserTier> createUserTier(UserTier userTier) {
    UserTier savedUserTier = userTierRepo.save(userTier);
    String location = String.format("/api/userTier/%s", savedUserTier.getId());
    //ToDo: log
    return ResponseEntity.created(URI.create(location)).body(savedUserTier);
  }
  
  public ResponseEntity<UserTier> updateUserTierById(int id, UserTier newUserTier) {
    Optional<UserTier> userTier = userTierRepo.findById(id);
    if (userTier.isPresent()) {
      newUserTier.setId(id);
      userTierRepo.save(newUserTier);
      //ToDo: log
      return ResponseEntity.ok(userTier.get());
    }
    //ToDo: log
    return ResponseEntity.badRequest().build();
  }

  public ResponseEntity<UserTier> deleteUserTierById(int id){
    Optional<UserTier> userTier = userTierRepo.findById(id);
    if (userTier.isPresent()) {
      userTierRepo.deleteById(id);
      //ToDo: log
      return ResponseEntity.noContent().build();
    }
    //ToDo: log
    return ResponseEntity.badRequest().build();
  }


}

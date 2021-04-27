package com.revature.carFinder.Controllers;

import java.util.List;

import com.revature.carFinder.models.UserTier;
import com.revature.carFinder.services.UserTierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/api/usertier", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class UserTierController {

  @Autowired
  private UserTierService userTierService;

  @GetMapping("")
  public ResponseEntity<List<UserTier>> getAllUserTiers(){
    return userTierService.getAllUserTiers();
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<UserTier> getUserTierById(@PathVariable("id") int id){
    return userTierService.getUserTierById(id);
  }
  @PostMapping("")
  public ResponseEntity<UserTier> createUserTier(@RequestBody UserTier userTier){
    return userTierService.createUserTier(userTier);
  }
  
  @PutMapping("id/{id}")
  public ResponseEntity<UserTier> updateUserTier(@PathVariable("id") int id, @RequestBody UserTier userTier) {
    return userTierService.updateUserTierById(id, userTier);
  }

  @DeleteMapping("id/{id}")
  public ResponseEntity<UserTier> deleteUserTier(@PathVariable("id") int id) {
    return userTierService.deleteUserTierById(id);
  }
}

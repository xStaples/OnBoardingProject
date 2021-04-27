package com.revature.carFinder.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.revature.carFinder.models.User;
import com.revature.carFinder.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
@Autowired
private UserRepo userRepo;

public ResponseEntity<List<User>> getAllUsers() {
  return ResponseEntity.ok(userRepo.findAll());
}

public ResponseEntity<User> getUserById(int id) {
  Optional<User> user = userRepo.findById(id);
  if(user.isPresent()) {
    //ToDo: log
    return ResponseEntity.ok(user.get());
  }
    //ToDo: log
  return ResponseEntity.badRequest().build();
}

public ResponseEntity<User> createUser(User user) {
  User savedUser = userRepo.save(user);
  String location = String.format("/api/user/%s", savedUser.getUserId());
  //ToDo: log
  return ResponseEntity.created(URI.create(location)).body(savedUser);
}

public ResponseEntity<User> updateUserById(int id, User newUser) {
  Optional<User> user = userRepo.findById(id);
  if (user.isPresent()) {
    newUser.setUserId(id);
    userRepo.save(newUser);
    //ToDo: log
    return ResponseEntity.ok(user.get());
  }
  //ToDo: log
  return ResponseEntity.badRequest().build();
}

public ResponseEntity<User> deleteUserById(int id){
  Optional<User> user = userRepo.findById(id);
  if (user.isPresent()) {
    userRepo.deleteById(id);
    //ToDo: log
    return ResponseEntity.noContent().build();
  }
  //ToDo: log
  return ResponseEntity.badRequest().build();
}


}

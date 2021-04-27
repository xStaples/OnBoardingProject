package com.revature.carFinder.Controllers;

import java.util.List;

import com.revature.carFinder.models.User;
import com.revature.carFinder.services.UserService;

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
@RequestMapping(value= "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("")
  public ResponseEntity<List<User>> getAllUsers(){
    return userService.getAllUsers();
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") int id){
    return userService.getUserById(id);
  }
  @PostMapping("")
  public ResponseEntity<User> createUser(@RequestBody User user){
    return userService.createUser(user);
  }
  
  @PutMapping("id/{id}")
  public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
    return userService.updateUserById(id, user);
  }

  @DeleteMapping("id/{id}")
  public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
    return userService.deleteUserById(id);
  }
  
}

package com.revature.carFinder.repo;

import com.revature.carFinder.models.UserTier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTierRepo extends JpaRepository<UserTier, Integer> {

  //Custom Methods here. Example: Jdbc SQL queries.
  
}

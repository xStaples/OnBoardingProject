package com.revature.carFinder.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_tier")
public class UserTier {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tiersSequence")
  @SequenceGenerator(name="tierSequence", sequenceName="tiers_SEQ", allocationSize=1)
  private int id;

  @Column(name="tier_name")
  private String tierName;

  @Column(name="car_details")
  private int details;

  @Column(name="car_limit")
  private int carLimit;

  @Column(name="price")
  private double price;

  @Column(name="tier_type")
  @OneToMany(mappedBy="userTier")
  private List<User> customer;

  public UserTier() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTierName() {
    return tierName;
  }

  public void setTierName(String tierName) {
    this.tierName = tierName;
  }

  public int getDetails() {
    return details;
  }

  public void setDetails(int details) {
    this.details = details;
  }

  public int getCarLimit() {
    return carLimit;
  }

  public void setCarLimit(int carLimit) {
    this.carLimit = carLimit;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public List<User> getCustomer() {
    return customer;
  }

  public void setCustomer(List<User> customer) {
    this.customer = customer;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + carLimit;
    result = prime * result + ((customer == null) ? 0 : customer.hashCode());
    result = prime * result + details;
    result = prime * result + id;
    long temp;
    temp = Double.doubleToLongBits(price);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((tierName == null) ? 0 : tierName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserTier other = (UserTier) obj;
    if (carLimit != other.carLimit)
      return false;
    if (customer == null) {
      if (other.customer != null)
        return false;
    } else if (!customer.equals(other.customer))
      return false;
    if (details != other.details)
      return false;
    if (id != other.id)
      return false;
    if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
      return false;
    if (tierName == null) {
      if (other.tierName != null)
        return false;
    } else if (!tierName.equals(other.tierName))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "UserTier [carLimit=" + carLimit + ", customer=" + customer + ", details=" + details + ", id=" + id
        + ", price=" + price + ", tierName=" + tierName + "]";
  }

  
}

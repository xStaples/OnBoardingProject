package models;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Cars {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carsSequence")
	@SequenceGenerator(name="carsSequence", sequenceName="cars_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="make", nullable=false)
	private String make;
	
	@Column(name="model", nullable=false)
	private String model;
	
	@Column(name="year", nullable=false)
	private int year;
	
	@Column(name="price", nullable=false)
	private double price;
	
	@Column(name="color", nullable=false)
	private String color;
	
	
	@ManyToOne()
	@JoinColumn(name= "", nullable = false)
	private User owner;
	
	
	
	

}

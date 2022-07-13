package com.pizzaApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table
public class Pizza {
	@Id
	@SequenceGenerator(
	           name ="user_sequence",
	           sequenceName = "user_sequence",
	           allocationSize = 1
	   )
	@GeneratedValue(
	           strategy = GenerationType.SEQUENCE,
	           generator = "user_sequence"
	   )
	private int pizzaId;
	private String pizzaType;
	private String pizzaName;
	private String pizzaDescription;
	private double pizzaCost;
	private double pizzaCostAfterCoupan;
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaDescription() {
		return pizzaDescription;
	}
	public void setPizzaDescription(String pizzaDescription) {
		this.pizzaDescription = pizzaDescription;
	}
	public double getPizzaCost() {
		return pizzaCost;
	}
	public void setPizzaCost(double pizzaCost) {
		this.pizzaCost = pizzaCost;
	}
	public double getPizzaCostAfterCoupan() {
		return pizzaCostAfterCoupan;
	}
	public void setPizzaCostAfterCoupan(double pizzaCostAfterCoupan) {
		this.pizzaCostAfterCoupan = pizzaCostAfterCoupan;
	}


}

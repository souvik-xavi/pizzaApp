package com.pizzaApp.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class PizzaOrder {
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
	private int bookingOrderId;
	private LocalDate dateOfOrder;
	private String transactionMode;
	private int quantity;
	private String size;//medium,regular,large
	private double totalCost;
	private int orderId;
	private int coupan;
	private double pizzaCostAfterCoupan;
	private String pizzaName;
	private int customerId;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBookingOrderId() {
		return bookingOrderId;
	}
	public int getOrderId() {
		return orderId;
	}
	public PizzaOrder(int bookingOrderId, LocalDate dateOfOrder, String transactionMode, int quantity, String size,
			double totalCost, int orderId, int coupan, double pizzaCostAfterCoupan) {
		this.bookingOrderId = bookingOrderId;
		this.dateOfOrder = dateOfOrder;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.size = size;
		this.totalCost = totalCost;
		this.orderId = orderId;
		this.coupan = coupan;
		this.pizzaCostAfterCoupan = pizzaCostAfterCoupan;
	}
	public PizzaOrder() {
	}
	public PizzaOrder(LocalDate dateOfOrder, String transactionMode, int quantity, String size, double totalCost,
			int orderId, int coupan, double pizzaCostAfterCoupan) {
		this.dateOfOrder = dateOfOrder;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.size = size;
		this.totalCost = totalCost;
		this.orderId = orderId;
		this.coupan = coupan;
		this.pizzaCostAfterCoupan = pizzaCostAfterCoupan;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setBookingOrderId(int bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}
	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getorderId() {
		return orderId;
	}
	public void setOrder(int orderId) {
		this.orderId = orderId;
	}
	public int getCoupan() {
		return coupan;
	}
	public void setCoupan(int coupan) {
		this.coupan = coupan;
	} 
	public double getPizzaCostAfterCoupan() {
		return pizzaCostAfterCoupan;
	}
	public void setPizzaCostAfterCoupan(double pizzaCostAfterCoupan) {
		this.pizzaCostAfterCoupan = pizzaCostAfterCoupan;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	


}

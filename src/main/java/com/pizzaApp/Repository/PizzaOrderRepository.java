package com.pizzaApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pizzaApp.Entity.PizzaOrder;

@Repository
public interface PizzaOrderRepository extends JpaRepository  {
	@Query("select u from PizzaOrder u where u.bookingOrderId=?1")
	PizzaOrder findBybookingOrderId(String PizzaOrder);

}
package com.pizzaApp.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.pizzaApp.Entity.PizzaOrder;
import com.pizzaApp.Repository.PizzaOrderRepository;

public class PizzaOrderServices {
	@Autowired
	PizzaOrderRepository pizzaOrderRepository;
	public boolean bookPizzaOrder(PizzaOrder pizzaOrder) {
		PizzaOrder P = PizzaOrderRepository.findBybookingOrderId(pizzaOrder.getBookingOrderId());
		
	}
	

}
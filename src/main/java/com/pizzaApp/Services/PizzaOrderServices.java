package com.pizzaApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaApp.Entity.PizzaOrder;
import com.pizzaApp.Repository.PizzaOrderRepository;

@Service
public class PizzaOrderServices {
	@Autowired
	PizzaOrderRepository pizzaOrderRepository;
	public boolean bookPizzaOrder(PizzaOrder pizzaOrder) {
		PizzaOrder P = pizzaOrderRepository.findBybookingOrderId(pizzaOrder.getorderId());


		return true;
	}
	

}
package com.pizzaApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaApp.Entity.PizzaOrder;
import com.pizzaApp.Exceptions.ResourceNotFoundException;
import com.pizzaApp.Repository.CustomerRepository;
import com.pizzaApp.Repository.PizzaOrderRepository;
import com.pizzaApp.Repository.PizzaRepository;

@Service
public class PizzaOrderServices {
	@Autowired
	PizzaOrderRepository pizzaOrderRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	PizzaRepository pizzaRepository;
	public boolean bookPizzaOrder(PizzaOrder pizzaOrder, int customerId, int pizzaid) {
		if(customerRepository.findById(customerId).isEmpty()){
			throw new ResourceNotFoundException("User not found ");
		}
		if(pizzaRepository.findById(pizzaid).isEmpty()){
			throw new ResourceNotFoundException("User not found ");
		}
		pizzaOrder.setCustomerId(customerId);
		pizzaOrder.setPizzaName(pizzaRepository.findById(pizzaid).get().getPizzaName());
		pizzaOrderRepository.save(pizzaOrder);
		return true;
	}
	

}
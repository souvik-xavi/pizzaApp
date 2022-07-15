package com.pizzaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaApp.Entity.Customer;
import com.pizzaApp.Entity.PizzaOrder;
import com.pizzaApp.Exceptions.NotAdminException;
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
    public List FindPizzaByCustomerId(int customerId) {
		return pizzaOrderRepository.findByCustomerId(customerId);
		

    }
	public List FindPizzaOrder(int customerId) {
		Customer cust = customerRepository.findById(customerId).get();
		if(cust==null){
			throw new ResourceNotFoundException("User not found ");
		}
		else if (cust.gettype().equals("user")) {
			throw new NotAdminException("Access Denied");
			
		} else {
			return pizzaOrderRepository.findAll();
		}
	}


	

}
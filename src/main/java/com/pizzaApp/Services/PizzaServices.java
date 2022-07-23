package com.pizzaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaApp.Entity.Customer;
import com.pizzaApp.Entity.Pizza;
import com.pizzaApp.Exceptions.NotAdminException;
import com.pizzaApp.Exceptions.ResourceNotFoundException;
import com.pizzaApp.Repository.CustomerRepository;
import com.pizzaApp.Repository.PizzaRepository;

@Service
public class PizzaServices {
	@Autowired
	PizzaRepository pizzaRepository;

	@Autowired
	CustomerRepository customerRepository;

	public boolean add(Pizza pizza, int customerId) {
		Pizza piz = pizzaRepository.findBypizzaName(pizza.getPizzaName());

		Customer cust = customerRepository.findById(customerId).get();
		if (cust == null) {
			throw new ResourceNotFoundException("User not found ");
		} else if (cust.gettype().equals("user")) {
			throw new NotAdminException("Access Denied");
		}
		if (piz == null) {
			pizzaRepository.save(pizza);
			return true;
		} else {
			System.out.println("pizza already exist");
			return false;
		}
	}

	public void deletePizza(int pizzaId, int customerId) {
		Customer cust = customerRepository.findById(customerId).get();
		if (cust == null) {
			throw new ResourceNotFoundException("User not found ");
		} else if (cust.gettype().equals("user")) {
			throw new NotAdminException("Access Denied");
		} else if (pizzaRepository.findById(pizzaId).isPresent()) {
			pizzaRepository.deleteById(pizzaId);
		}
	}

	public Pizza updatePizza(Pizza pizza, int customerId) {
		Customer cust = customerRepository.findById(customerId).get();
		Pizza p = pizzaRepository.findById(pizza.getPizzaId()).get();
		if (cust == null) {
			throw new ResourceNotFoundException("User not found ");
		} else if (cust.gettype().equals("user")) {
			throw new NotAdminException("Access Denied");
		} else if (p!=null) {
			//Pizza p = pizzaRepository.findById(pizza.getPizzaId()).get();
			p.setPizzaCost(pizza.getPizzaCost());
			p.setPizzaDescription(pizza.getPizzaDescription());
			p.setPizzaName(pizza.getPizzaName());
			p.setPizzaType(pizza.getPizzaType());
			pizzaRepository.save(p);
			System.out.println(p.getPizzaName());
			return p;
			//pizzaRepository.findById(pizza.getPizzaId()).isPresent()
		}
		else {
			throw new ResourceNotFoundException("Pizza not found ");
		}
	}

	public List viewPizzaList() {
		return pizzaRepository.findAll();
	}

}

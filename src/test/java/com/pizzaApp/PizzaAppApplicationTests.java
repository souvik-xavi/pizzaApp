	package com.pizzaApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pizzaApp.Entity.Customer;
import com.pizzaApp.Entity.Pizza;
import com.pizzaApp.Entity.User;
import com.pizzaApp.Repository.CustomerRepository;
import com.pizzaApp.Repository.PizzaRepository;
import com.pizzaApp.Services.LoginServices;
import com.pizzaApp.Services.PizzaServices;

@SpringBootTest
class PizzaAppApplicationTests {

	@Autowired
	CustomerRepository cRepo;
	@Autowired
	LoginServices loginservices;
	
	@Test
	public void test() {
		Customer c= new Customer("souvik","souvikghata21@","souvik");
		cRepo.save(c);
		assertNotNull(cRepo.findAll());

	}

	
	
	
}

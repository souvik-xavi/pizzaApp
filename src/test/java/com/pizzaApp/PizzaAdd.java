package com.pizzaApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pizzaApp.Entity.Pizza;
import com.pizzaApp.Repository.PizzaRepository;
import com.pizzaApp.Services.PizzaServices;
@SpringBootTest
class pizzaAdd {
	@Autowired
	PizzaRepository pRepo;
	@Autowired
	PizzaServices pizzaservices;
	@Test
	public void testPizza() {
		Pizza p= new Pizza("Veg","XYZ","XYZXYZ",250);
		pRepo.save(p);
		assertNotNull(pRepo.findAll());
	
	}

}

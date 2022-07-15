package com.pizzaApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pizzaApp.Entity.Customer;
import com.pizzaApp.Entity.User;
import com.pizzaApp.Repository.CustomerRepository;
import com.pizzaApp.Services.LoginServices;

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

	@Test
	public void testLogin() {
		Customer c= new Customer("souvik","souvikghata21@","souvik");
		cRepo.save(c);
		User u=new User("souvikghata21@","souvik");
		User uf=new User("souvikghata21@","/souvik");
		String q=loginservices.login(u);
		assertEquals("accepted", q);
		String q1=loginservices.login(uf);
		assertEquals("declined", q1);
	}

}

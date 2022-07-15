package com.pizzaApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaApp.Entity.PizzaOrder;
import com.pizzaApp.Services.PizzaOrderServices;

@RestController
public class PizzaOrderController {
	@Autowired
	PizzaOrderServices pizzaorderservices;

	@PostMapping("/addPizzaOrder")
	public ResponseEntity bookPizzaOrder(@RequestBody PizzaOrder pizzaOrder)
	{
		if(pizzaorderservices.bookPizzaOrder(pizzaOrder))
        {
            return ResponseEntity.status(HttpStatus.OK).body(pizzaOrder);

        }

        	return ResponseEntity.status(HttpStatus.FOUND).body("pizzaOrder already exist");
	}
}
package com.pizzaApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaApp.Entity.PizzaOrder;
import com.pizzaApp.Services.PizzaOrderServices;

@RestController
public class PizzaOrderController {
	@Autowired
	PizzaOrderServices pizzaorderservices;

	@PostMapping("/addPizzaOrder/{customerId}/{pizzaid}")
	public ResponseEntity bookPizzaOrder(@RequestBody PizzaOrder pizzaOrder, @PathVariable int customerId,
			@PathVariable int pizzaid) {
		pizzaorderservices.bookPizzaOrder(pizzaOrder,customerId,pizzaid);
		return ResponseEntity.status(HttpStatus.OK).body("Pizza Deleted");
	}

	@GetMapping("/addPizzaOrder/{customerId}/")
	public ResponseEntity viewCustomerOrder( @PathVariable int customerId) {
		return ResponseEntity.status(HttpStatus.OK).body(pizzaorderservices.FindPizzaByCustomerId(customerId));
	}

	@GetMapping("/addPizzaOrder/admin/{customerId}/")
	public ResponseEntity viewAdminOrder( @PathVariable int customerId) {
		return ResponseEntity.status(HttpStatus.OK).body(pizzaorderservices.FindPizzaOrder(customerId));
	}

}
package com.pizzaApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaApp.Entity.Pizza;
import com.pizzaApp.Services.PizzaServices;

@RestController
public class PizzaController {
	@Autowired
	PizzaServices pizzaservices;
	public ResponseEntity addPizza(@RequestBody Pizza pizza) 
	{		
        if(pizzaservices.add(pizza))
        {
            return ResponseEntity.status(HttpStatus.OK).body(pizza);

        }

        	return ResponseEntity.status(HttpStatus.FOUND).body("pizza already exist");
}

}
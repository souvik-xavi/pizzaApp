package com.pizzaApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaApp.Entity.Pizza;
import com.pizzaApp.Services.PizzaServices;

@RestController
public class PizzaController {
	@Autowired
	PizzaServices pizzaservices;
	@PostMapping("/addPizza")
	public ResponseEntity addPizza(@RequestBody Pizza pizza) 
	{		
        if(pizzaservices.add(pizza))
        {
            return ResponseEntity.status(HttpStatus.OK).body(pizza);

        }

        	return ResponseEntity.status(HttpStatus.FOUND).body("pizza already exist");
		}
	@DeleteMapping("/delPizza/{id}")
	public ResponseEntity deletePizza(@PathVariable int id) 
	{
		pizzaservices.deletePizza(id);
		return ResponseEntity.status(HttpStatus.OK).body("Pizza Deleted");
		
	}
	@PutMapping("/updatePizza")
	public ResponseEntity updatePizza(@RequestBody Pizza pizza) 
	{		
        pizzaservices.updatePizza(pizza);
        return ResponseEntity.status(HttpStatus.FOUND).body("Pizza Updated");
	}
	@GetMapping("/viewPizza")
	public List viewPizza()
	{
		return pizzaservices.viewPizzaList(	);
		
	}

}
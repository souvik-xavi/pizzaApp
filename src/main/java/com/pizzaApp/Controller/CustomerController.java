package com.pizzaApp.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaApp.Entity.Customer;
@RestController
public class CustomerController {
	
    @GetMapping(value="/")
	public  String add(){
        return "Hello World";
    }
    @PostMapping("/request")	
    public ResponseEntity postController(      @RequestBody Customer loginF  		) 
    		{
    			System.out.println(loginF.getCustomerName());
    			System.out.println(loginF.getCustomerEmail());
    			System.out.println(loginF.getPassword());
     
      
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

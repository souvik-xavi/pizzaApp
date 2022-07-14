package com.pizzaApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaApp.Entity.Customer;
import com.pizzaApp.Entity.User;
import com.pizzaApp.Services.LoginServices;
@RestController
public class CustomerController {
    @Autowired
    LoginServices loginservices;
	
    @GetMapping(value="/")
	public  String add(){
        return "Hello World";
    }


    @PostMapping("/register")	
    public ResponseEntity register(@RequestBody Customer customer) 
    		{
    		
                if(loginservices.register(customer)){
                    return ResponseEntity.status(HttpStatus.OK).body(customer);

                }

     
      
        return ResponseEntity.status(HttpStatus.FOUND).body("customer already exist");
    }

    @PostMapping("/login")	
    public ResponseEntity login(@RequestBody User customer) 
    		{
    		
            loginservices.login(customer);   
     
      
        return ResponseEntity.status(HttpStatus.FOUND).body("Hi");
    }
}

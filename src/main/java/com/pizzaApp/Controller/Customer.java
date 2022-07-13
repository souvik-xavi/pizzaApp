package com.pizzaApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Customer {

    @GetMapping(value="/")
	public  String add(){
        return "Hello World";
    }
    
}

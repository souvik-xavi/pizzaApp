package com.pizzaApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class customer {

    @GetMapping(value="/")
	public  String add(){
        return "Hello World";
    }
    
}

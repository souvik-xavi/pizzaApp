package com.pizzaApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaApp.Entity.Pizza;
import com.pizzaApp.Repository.PizzaRepository;


@Service
public class PizzaServices {
	@Autowired
    PizzaRepository pizzaRepository;
    public boolean add(Pizza pizza) {
        Pizza piz=pizzaRepository.findBypizzaName(pizza.getPizzaName());
        if(piz==null){
            pizzaRepository.save(pizza);
            return true;
        }
        else{
            System.out.println("pizza already exist");
            return false;
        }
    }
        
    	public void deletePizza(int pizzaId) 
    	{
    		//Pizza pizza=PizzaRepository.findById(pizzaId);
    		pizzaRepository.deleteById(pizzaId);      
    	}
    }

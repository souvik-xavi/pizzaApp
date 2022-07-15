package com.pizzaApp.Services;

import java.util.List;

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
    		if(pizzaRepository.findById(pizzaId).isPresent())
    		{
    			pizzaRepository.deleteById(pizzaId);
    		}
    	}

		public void updatePizza(Pizza pizza) 
		{
			if(pizzaRepository.findById(pizza.getPizzaId()).isPresent())
    		{
    			Pizza p=pizzaRepository.findById(pizza.getPizzaId()).get();
    			p.setPizzaCost(pizza.getPizzaCost());
    			p.setPizzaDescription(pizza.getPizzaDescription());
    			p.setPizzaName(pizza.getPizzaName());
    			p.setPizzaType(pizza.getPizzaType());
    			pizzaRepository.save(p);
    		}
		}

		public List viewPizzaList() 
		{
			return pizzaRepository.findAll();
		}
    	
    }

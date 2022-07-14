package com.pizzaApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaApp.Entity.Customer;
import com.pizzaApp.Entity.User;
import com.pizzaApp.Repository.CustomerRepository;

@Service
public class LoginServices {
    @Autowired
    CustomerRepository customerRepository;
    public boolean register(Customer customer) {
        Customer cust=customerRepository.findByCustomerEmail(customer.getCustomerEmail());
        if(cust==null){
            customerRepository.save(customer);
            return true;
        }
        else{
            System.out.println("customer already exist");
            return false;
        }
        

    }
    public String login(User customer) {

        Customer cust=customerRepository.findByCustomerEmail(customer.getUserEmail());
        if(cust==null){
            return "UNF";
        }
        else{
            if(cust.getPassword().equals(customer.getUserPassword())){
                return "accepted";
            }
        }

        return "declined";
        
    }
    
}

package com.pizzaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaApp.Entity.Coupan;
import com.pizzaApp.Entity.Customer;
import com.pizzaApp.Exceptions.NotAdminException;
import com.pizzaApp.Exceptions.ResourceNotFoundException;
import com.pizzaApp.Repository.CouponRepository;
import com.pizzaApp.Repository.CustomerRepository;

@Service
public class CouponService {
    @Autowired
    CouponRepository couponRepository;
    @Autowired
	CustomerRepository customerRepository;

    public boolean addCoupon(Coupan coupan, int customerId){
        Customer cust = customerRepository.findById(customerId).get();
        if(cust==null){
            throw new ResourceNotFoundException("User not found ");
        }
        else if (cust.gettype().equals("user")) {
            throw new NotAdminException("Access Denied");
        }else{

        couponRepository.save(coupan);
        return true;
        }
    }

    public List viewCoupon(){
        List<Coupan> coupans = couponRepository.findAll();
        return coupans;
    }
}

package com.pizzaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaApp.Entity.Coupan;
import com.pizzaApp.Repository.CouponRepository;

@Service
public class CouponService {
    @Autowired
    CouponRepository couponRepository;

    public boolean addCoupon(Coupan coupan){

        couponRepository.save(coupan);
        return true;

    }

    public List viewCoupon(){
        List<Coupan> coupans = couponRepository.findAll();
        return coupans;
    }
}

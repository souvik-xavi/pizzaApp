package com.pizzaApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaApp.Entity.Coupan;
import com.pizzaApp.Services.CouponService;

@RestController
public class CouponController {
    @Autowired
    CouponService couponService;

    @PostMapping("/addCoupon/{customerId}")
    public Boolean addCoupon(@RequestBody Coupan coupan,@PathVariable int customerId) {

        couponService.addCoupon(coupan,customerId);

        return true;
    }

    @GetMapping("/viewCoupon")
    public List viewCoupon(@RequestBody Coupan coupan) {

        return couponService.viewCoupon();

    
    }
}

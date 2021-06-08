package com.service.coupon.controller;

import com.service.coupon.model.Coupon;
import com.service.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/couponApi")
public class CouponController {

    private final CouponService couponService;

    @Autowired
    private ServletContext context;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/coupons")
    public Coupon getCoupons(){
        System.out.println("Inside CouponController getCoupons");
        Coupon coupon = new Coupon();
        coupon.setCode("11CDFD");
        coupon.setDiscount(new BigDecimal(23));
        coupon.setExpDate("12345");
        coupon.setId(UUID.randomUUID().toString());
        return coupon;
    }

    @PostMapping("/coupons")
    public String add(@RequestBody Coupon coupon) throws InterruptedException {
        System.out.println("context path: " + context.getContextPath());
        couponService.applyCouponDiscount(coupon, "apple");
        return "product and coupon added";
    }
}

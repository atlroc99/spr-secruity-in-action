package com.service.coupon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CouponController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/new-coupon")
    public String getCouponForm() {
        return "couponForm";
    }

}

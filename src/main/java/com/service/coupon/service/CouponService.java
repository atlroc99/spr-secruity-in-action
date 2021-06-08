package com.service.coupon.service;

import com.service.coupon.model.Coupon;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    /// this service class does not really store any coupon information, but
    // it takes the coupon code from the customer and calls Product service / api
    // apply the coupon and store the products ?
    public void applyCouponDiscount(Coupon coupon, String productName) throws InterruptedException {
        System.out.println("Calling Product service rest api...: " + productName);
        Thread.sleep(1000);

        System.out.println("Retrieve PRODUCT object: " + productName);
        Thread.sleep(1000);

        System.out.println("apply coupon code on the product price");
        Thread.sleep(1000);

        System.out.println("return final value" + coupon.getCode());

    }
}

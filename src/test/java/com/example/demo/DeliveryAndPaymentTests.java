package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.PostDeliveryStrategy;
import com.example.demo.flower.Flower;
import com.example.demo.flower.FlowerColor;
import com.example.demo.flower.FlowerType;
import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.PayPalPaymentStrategy;

public class DeliveryAndPaymentTests {

    static final int PRICE = 10;
    static final int SEPALLENGTH = 10;

    @Test
    void creatingFirstOrder() {
        Order myOrder = new Order(
        List.of((
            new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, 
                FlowerType.ROSE)),
            new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, 
                FlowerType.ROSE),
            new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, 
                FlowerType.ROSE)),
            new DHLDeliveryStrategy(), 
            new PayPalPaymentStrategy());
        Assertions.assertEquals(myOrder.getDelivery()
        .getDeliveryNotification(), "Delivery with DHL");
        Assertions.assertEquals(myOrder.getPayment()
        .paymentMessage(), "Payed with PayPal");        
    }

    @Test
    void creatingSecondOrder() {
        Order myOrder = new Order(
        List.of((
            new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, 
                FlowerType.ROSE)),
            new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, 
                FlowerType.ROSE),
            new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE,
                FlowerType.ROSE)),
            new PostDeliveryStrategy(), 
            new CreditCardPaymentStrategy());  
        Assertions.assertEquals(myOrder.getDelivery().getDeliveryNotification(), 
        "Delivery with simple Post");
        Assertions.assertEquals(myOrder.getPayment().paymentMessage(),
         "Payed with card");     
    }

}

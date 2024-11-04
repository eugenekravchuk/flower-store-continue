package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.PostDeliveryStrategy;
import com.example.demo.flower.Flower;
import com.example.demo.flower.FlowerColor;
import com.example.demo.flower.FlowerType;
import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.PayPalPaymentStrategy;

@SpringBootApplication
@RestController
public class DemoApplication {
	final static int PRICE = 10;
	final static int SEPALLENGTH = 10;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/order")
	public static List<Order> listFlowers() {
		return List.of(
				new Order(
			List.of((new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, FlowerType.ROSE)),
					new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, FlowerType.ROSE),
					new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, FlowerType.ROSE)),
			new DHLDeliveryStrategy(), 
			new PayPalPaymentStrategy()),
	new Order(
			List.of((new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, FlowerType.ROSE)),
					new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, FlowerType.ROSE),
					new Flower(SEPALLENGTH, FlowerColor.BLUE, PRICE, FlowerType.ROSE)),
			new PostDeliveryStrategy(), 
			new CreditCardPaymentStrategy()));

	}
}

package com.rohit.spring_boot_fundamentals;

import com.rohit.spring_boot_fundamentals.vehicle.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootFundamentalsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootFundamentalsApplication.class, args);

		Car car = context.getBean(Car.class);

		car.drive();
	}
}
package com.rohit.spring_boot_fundamentals.vehicle;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    public void start() {
        System.out.println("Engine started");
    }

}

package com.bpc.upandrunning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
//    @Value("${greeting-name: Mirage}")
//    private String name;
//
//    @Value("${greeting-coffee: ${greeting-name} is drinking Cafe Ganador }")
//    private String coffee;

    private final Greeting greetingProps;

    public GreetingController(Greeting greetingProps){
        this.greetingProps = greetingProps;
    }
    @GetMapping
    String getGreeting(){
        return greetingProps.getName();
    }

    @GetMapping("/coffee")
    String getCoffee(){
        return greetingProps.getCoffee();
    }

    @GetMapping("/qty")
    int getQty(){
        return greetingProps.getQty();
    }
}

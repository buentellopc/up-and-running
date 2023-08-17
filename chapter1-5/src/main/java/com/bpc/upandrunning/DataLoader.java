package com.bpc.upandrunning;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoader {
    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData(){
        coffeeRepository.saveAll(List.of(new Coffee("Cafe cereza"), new Coffee("Cafe ganador"), new Coffee("cafe lareno"), new Coffee("cafe tim horton")));
    }
}

package com.bpc.redistemplateservice;


import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
public class PlaneFinderPoller {

    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    private RedisConnectionFactory connectionFactory;
    private final AircraftRepository aircraftRepository;

    public PlaneFinderPoller(AircraftRepository aircraftRepository, RedisConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
        this.aircraftRepository = aircraftRepository;
    }

    @Scheduled(fixedRate = 1000)
    private void pollPlanes() {
        // Borrar datos existentes
        connectionFactory.getConnection().serverCommands().flushDb();

        // Guarda aircrafts
        client.get()
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(aircraft -> !aircraft.getReg().isEmpty())
                .toStream()
                .forEach(aircraftRepository::save);

        aircraftRepository.findAll()
                .forEach(System.out::println);

    }
}

package com.playground.reactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ReactorService {

    public Mono<String> reactorTestPreretry(String input) {
        return Mono.just(input)
                .map(ReactorService::test)
                .doOnError(System.err::println)
                .doOnSuccess(System.out::println)
                .retry(3);
    }

    public Mono<String> reactorTestPostretry(String input) {
        return Mono.just(input)
                .map(ReactorService::test)
                .retry(3)
                .doOnError(System.err::println)
                .doOnSuccess(System.out::println);
    }

    private static String test(String input) {
        if (input.equals("error")) {
            System.out.println("Exception");
            throw new IllegalArgumentException("Error");
        }
        return "Success";
    }


}

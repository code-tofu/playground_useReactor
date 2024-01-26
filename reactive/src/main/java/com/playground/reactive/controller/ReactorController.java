package com.playground.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.playground.reactive.service.ReactorService;

@RestController
public class ReactorController {

    @Autowired
    ReactorService reactorService;
    
    @GetMapping("/test1/{input}")
    public ResponseEntity<String> test1(@PathVariable String input){
        reactorService.reactorTestPreretry(input).subscribe(e -> System.out.println("subscriber error"));
        System.out.println("complete");
        return ResponseEntity.ok("Completed");
    }

    @GetMapping("/test2/{input}")
    public ResponseEntity<String> test2(@PathVariable String input){
        reactorService.reactorTestPostretry(input).subscribe(e -> System.out.println("subscriber error"));
        System.out.println("complete");
        return ResponseEntity.ok("Completed");
    }

    
}

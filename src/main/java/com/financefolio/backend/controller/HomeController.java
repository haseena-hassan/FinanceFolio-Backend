package com.financefolio.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("")
    public ResponseEntity getAccounts() {
        String hello = "Hello World from Java";
        return ResponseEntity.status(HttpStatus.OK).body(hello);
    }
}



package com.example.aop.controller;

import com.example.aop.Calculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping(value = "/sum")
    public ResponseEntity<String> sum() {
        Calculator calculator = new Calculator();

        long ret = calculator.sum(1, 10000000);
        return ResponseEntity.ok(String.valueOf(ret));
    }
}

package edu.tusur.kp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class DatabaseController {

    @GetMapping("/test")
    public void testMethod() {
        System.out.println("testMethod");
    }

}

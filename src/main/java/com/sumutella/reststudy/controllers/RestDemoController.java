package com.sumutella.reststudy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sumutella
 * @time 6:35 PM
 * @since 11/22/2019, Fri
 */
@RestController
@RequestMapping("/")
public class RestDemoController {
    @GetMapping("")
    public String showHello(){
        return "Rest Demo says hellooo!";
    }
}

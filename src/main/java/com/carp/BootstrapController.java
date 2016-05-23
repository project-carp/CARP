package com.carp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BootstrapController {

    @RequestMapping("/")
    public String index() {
        return "Carpooling!!!";
    }

}
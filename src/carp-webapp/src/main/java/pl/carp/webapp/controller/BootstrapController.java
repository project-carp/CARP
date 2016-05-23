package pl.carp.webapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BootstrapController {

    @RequestMapping("/")
    public String index() {
        return "Carpooling!!!";
    }
}
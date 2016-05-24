package pl.carp.webapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rs/")
public class MaintenanceController {


    @RequestMapping("/version")
    public String index() {
        return "0.0.1";
    } //TODO inject gradle build version
}
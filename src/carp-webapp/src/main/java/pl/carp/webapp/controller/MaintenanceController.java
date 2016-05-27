package pl.carp.webapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.carp.common.version.Version;

@RestController
@RequestMapping("/rs/")
public class MaintenanceController {

    @RequestMapping("/version")
    public String index() {
        return Version.VERSION;
    }
}
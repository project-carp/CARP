package pl.carp.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Maciej Iskra(mais) on 2016-05-24.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String response(){
        return "HelloWorld!";
    }

}

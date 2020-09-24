package com.group.foctg.holidayMaker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "landingpage.html";
    }

    @GetMapping("/accommodation")
    public String accommodation() {
        return "accommodation.html";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard.html";
    }

}

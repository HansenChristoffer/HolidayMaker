package com.group.foctg.holidayMaker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

	@GetMapping("/")
    public String init() {
        return "landingpage.html";
    }
	
	@GetMapping("/login")
    public String asdf() {
        return "landingpage.html";
    }

    @GetMapping("/accommodation")
    public String accommodation() {
        return "accommodation.html";
    }
	@GetMapping("/dashboard")
	public String init3() {
		return "dashboard.html";
	}

}

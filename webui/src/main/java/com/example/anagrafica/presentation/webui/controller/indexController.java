package com.example.anagrafica.presentation.webui.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class indexController {

    @GetMapping ("/index")
    public String getIndex() {
    	 return "index";
    }
    
    @PostMapping("/index")
    public String postIndex() {
    	return "index";
    }
}
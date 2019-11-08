package com.example.anagrafica.presentation.webui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewClientController {
	
    @GetMapping ("/NewClient")
    public String getNewClient() {
    	 return "NewClient";
    }
    
    @PostMapping("/NewClient")
    public String postNewClient() {
    	return "error";
    }
}

package com.example.anagrafica.presentation.webui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class errorController {

    @GetMapping ("/error")
    public String getError() {
    	//mostra la pagina di errore
    	return "index";
    }
    
    @PostMapping("/error")
    public String postError() {
    	
    	return "index";
    }
}

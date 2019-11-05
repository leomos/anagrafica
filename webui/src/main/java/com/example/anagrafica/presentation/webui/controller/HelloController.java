package com.example.anagrafica.presentation.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;

@Controller
public class HelloController {
	
	@Autowired
	ClienteService clienteService;
	
    @GetMapping("/hello")
    public String index() {
    	System.out.println(clienteService.get(1));
        return "index";
    }

    @PostMapping("/hello") 
    public String sayhello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}
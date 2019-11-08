package com.example.anagrafica.presentation.webui.controller;

import javax.validation.Valid;

import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.validator.ClienteValidator;

@RequestMapping("/MergeRobiSamu")
@Controller
public class ClienteUpdateController {
	@Autowired
	ClienteService clienteService;

	@PostMapping("/clienti/update")
	public String update(@RequestParam("cf") String cf, Model model, @ModelAttribute Cliente cliente,
			BindingResult result) {
		ClienteValidator cv=new ClienteValidator();
		cv.validate(cliente, result);
		try {
			if (result.hasErrors()) {
				for (ObjectError e:result.getAllErrors()) {
					
					model.addAttribute("messaggioErroreUpdate",e.getCode());
					
					
				}
				model.addAttribute("aggiornato", false);
			} else {
				Boolean bool = this.clienteService.update(cliente);
				model.addAttribute("aggiornato", bool);
			}
		} catch (Exception e) {
			model.addAttribute("aggiornato", false);
		}

		return "pagina2";
	}
}
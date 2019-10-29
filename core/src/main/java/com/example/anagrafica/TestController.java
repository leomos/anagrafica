package com.example.anagrafica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;
import com.example.anagrafica.data.Indirizzo;
import com.example.anagrafica.data.IndirizzoCliente;
import com.example.anagrafica.data.IndirizzoClientePK;
import com.example.anagrafica.data.IndirizzoClienteRepository;
import com.example.anagrafica.data.IndirizzoRepository;

@Controller
public class TestController {
	
	@Autowired
	IndirizzoRepository indirizzoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	IndirizzoClienteRepository indirizzoClienteRepository;
	
	@Autowired
	ClienteService clienteService;
}

package com.example.anagrafica.presentation.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteFilter;
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
@RequestMapping("/MergeRobiSamu")
@Controller
public class ClienteReadController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/")

	public String getAll(Model model, @RequestParam(value = "cf", defaultValue = "") String cf) {
		if (cf == null || cf.isEmpty()) {
			model.addAttribute("clienteCollection", clienteService.getAll());
//			model.addAttribute("cfVuoto", true);
		} else if (!clienteService.getByCf(cf).isPresent() || !clienteService.getByCf(cf).get().isVisibile()) {
			model.addAttribute("cercato", false);
		} else {
			model.addAttribute("clienteCollection", clienteService.getByCf(cf).get());
		}
		return "index";
	}

	@GetMapping("/clienti/{id}")
	public String getById(Model model, @PathVariable("id") int id) {
		model.addAttribute("cliente", clienteService.get(id).get());
		return "pagina2";
	}

	@GetMapping("/clienti/filter")
	public String index(@ModelAttribute ClienteFilter cf, ModelMap model, HttpServletResponse response)
			throws Exception {

		boolean trovato = true;

		String messaggioDiErrore = "";

		ArrayList<String> ms = new ArrayList<String>();
		System.out.println(cf.getDataFinale());
		try {
			
			 Date dataInizialeParz=new SimpleDateFormat("yyyy-MM-dd").parse(cf.getDataIniziale());  
			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			    String strDateIniz= formatter.format(dataInizialeParz);
			cf.setDataIniziale(strDateIniz);
			

			 Date dataFinaleParz=new SimpleDateFormat("yyyy-MM-dd").parse(cf.getDataFinale());  
			 
			    String strDateFin= formatter.format(dataFinaleParz);
			cf.setDataFinale(strDateFin);
			

			Collection<Cliente> cc = clienteService.findWithFilter(cf);

			if (cc.isEmpty()) {
				Cliente errore = new Cliente();
				cc.add(errore);
				trovato = false;
			}

			ms.add(messaggioDiErrore);

			model.addAttribute("trovato", trovato);
			model.addAttribute("clienteCollection", cc);
			model.addAttribute("messaggioDiErrore", ms);

			return "index";
		} catch (Exception e) {

			ArrayList<Cliente> cc = new ArrayList<>();
			Cliente errore = new Cliente();
			cc.add(errore);
			trovato = false;

			ms.add(messaggioDiErrore);

			messaggioDiErrore = "errore,dati inseriti in formato errato ";
			model.addAttribute("messaggioDiErrore", ms);
			model.addAttribute("trovato", trovato);
			model.addAttribute("clienteCollection", cc);

			response.addHeader("Content-Security-Policy", "frame-ancestors 'self'");
			return "index";
		}

	}

	@GetMapping("/clienti/filter/{id}")
	public String getOne(@PathVariable("id") String id, ModelMap model, HttpServletResponse response) {
		boolean trovato;
		ArrayList<String> ms = new ArrayList<String>();
		String messaggioDiErrore = "";
		try {

			Optional<Cliente> c = clienteService.get(Integer.parseInt(id));
			ArrayList<Cliente> cc = new ArrayList<>();

			if (!c.isPresent()) {

				Cliente errore = new Cliente();
				cc.add(errore);
				ms.add(messaggioDiErrore);
				model.addAttribute("messaggioDiErrore", ms);

				trovato = false;

			} else {

				trovato = true;

				cc.add(c.get());
			}

			model.addAttribute("trovato", trovato);
			model.addAttribute("clienteCollection", cc);

			response.addHeader("Content-Security-Policy", "frame-ancestors 'self'");
			return "index";

		} catch (Exception e) {

			ArrayList<Cliente> cc = new ArrayList<>();
			Cliente errore = new Cliente();
			cc.add(errore);
			trovato = false;

			messaggioDiErrore = "errore,id non riconosciuto";
			ms.add(messaggioDiErrore);

			model.addAttribute("messaggioDiErrore", ms);
			model.addAttribute("trovato", trovato);
			model.addAttribute("clienteCollection", cc);
			response.addHeader("Content-Security-Policy", "frame-ancestors 'self'");

			return "index";

		}
	}
}

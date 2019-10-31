package com.example.anagrafica.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

@Endpoint
public class ClienteEndpoint {
	private static final String NAMESPACE_URI = "presentation.anagrafica.example.com";

	@Autowired
	private ClienteService clienteService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "postModificaClienteRequest")
	@ResponsePayload
	public PostModificaClienteResponse postModificaCliente(@RequestPayload PostModificaClienteRequest request)
			throws Exception {
		System.out.println(request.getClienteX().getIdCliente());
		String risposta = "";
		Cliente cli = new Cliente(request.getClienteX().getNome(), request.getClienteX().getCognome(),
				request.getClienteX().getSesso().charAt(0), request.getClienteX().getCf(),
				dataCreator(request.getClienteX().getDataDiNascita()), request.getClienteX().getLuogoDiNascita(),
				request.getClienteX().getMail(), request.getClienteX().getTelefono());
		cli.setId(request.getClienteX().getIdCliente());

		if (clienteService.update(

				cli)) {

			risposta += "cliente modificato";

		} else {
			risposta += "cliente da modificare non trovato";
		}

		PostModificaClienteResponse response = new PostModificaClienteResponse();
		response.setRisposta(risposta);
		return response;
	}

	public Date dataCreator(String args) throws Exception {

		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(args);

		return date1;
	}

}

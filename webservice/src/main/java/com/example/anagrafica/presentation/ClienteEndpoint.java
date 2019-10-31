package com.example.anagrafica.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.anagrafica.business.ClienteService;

@Endpoint
public class ClienteEndpoint {
	private static final String NAMESPACE_URI = "presentation.anagrafica.example.com";

	@Autowired
	private ClienteService clienteService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClienteRequest")
	@ResponsePayload
	public GetDeletedClienteResponse deleteCliente(@RequestPayload DeleteClienteRequest request) {
		System.out.println(request.idCliente);
		GetDeletedClienteResponse response = new GetDeletedClienteResponse();
		System.out.print(clienteService.get(request.idCliente).get().isVisibile());
		response.setClienteVisibile(this.clienteService.deleteLogical(clienteService.get(request.idCliente).get()));      
		System.out.print(this.clienteService.deleteLogical(clienteService.get(request.idCliente).get()));
		return response;
	}
}

package com.example.anagrafica.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.anagrafica.business.IndirizzoService;
import com.example.anagrafica.presentation.GetListaIndirizziResponse;
import com.example.anagrafica.presentation.GetListaIndirizziRequest;

@Endpoint
public class IndirizzoEndpoint {
	private static final String NAMESPACE_URI = "presentation.anagrafica.example.com";

	@Autowired
	private IndirizzoService indirizzoService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListaIndirizziRequest")
	@ResponsePayload
	public GetListaIndirizziResponse getListaIndirizzi(@RequestPayload GetListaIndirizziRequest request) {
		System.out.println(request.idCliente);
		GetListaIndirizziResponse response = new GetListaIndirizziResponse();
		String luogo = this.indirizzoService.get(1).get().getLuogo();
		System.out.println(luogo);
		response.getLuogo().add(luogo);
		response.getLuogo().add(luogo);
		return response;
	}
}

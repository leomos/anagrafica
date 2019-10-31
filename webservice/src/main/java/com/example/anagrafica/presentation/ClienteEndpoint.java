package com.example.anagrafica.presentation;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.business.ClienteService;

@Endpoint
public class ClienteEndpoint {
	private static final String NAMESPACE_URI = "presentation.anagrafica.example.com";

	@Autowired
	private ClienteService clienteService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientiVisibiliRequest")
	@ResponsePayload
	public GetClientiVisibiliResponse getClientiVisibili(@RequestPayload GetClientiVisibiliRequest request) {
		GetClientiVisibiliResponse response = new GetClientiVisibiliResponse();
        for(Cliente cl:this.clienteService.getAllVisibile()){
        	com.example.anagrafica.presentation.Cliente client=new com.example.anagrafica.presentation.Cliente();
        	client.setNome(cl.getNome());
        	client.setCognome(cl.getCognome());
        	client.setSesso(Character.toString(cl.getSesso()));
        	client.setCf(cl.getCf());
        	client.setDataDiNascita(cl.getDataDiNascita().toString());
        	client.setLuogoDiNascita(cl.getLuogoDiNascita());
        	client.setMail(cl.getMail());
        	client.setTelefono(cl.getTelefono());
        	response.getClientiVisibili().add(client);
        }
		return response;
		
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClienteByIdRequest")
	@ResponsePayload
	public GetDeletedClienteResponse deleteByIdCliente(@RequestPayload DeleteClienteByIdRequest request) {
		System.out.println(request.idCliente);
		GetDeletedClienteResponse response = new GetDeletedClienteResponse();
		System.out.print(clienteService.get(request.idCliente).get().isVisibile());
		response.setClienteVisibile(this.clienteService.deleteLogical(clienteService.get(request.idCliente).get()));      
		System.out.print(this.clienteService.deleteLogical(clienteService.get(request.idCliente).get()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClienteByCfRequest")
	@ResponsePayload
	public GetDeletedClienteResponse deleteByCfCliente(@RequestPayload DeleteClienteByCfRequest request) {
		System.out.println(request.cfCliente);
		GetDeletedClienteResponse response = new GetDeletedClienteResponse();
		System.out.print(clienteService.getByCf(request.cfCliente).get().isVisibile());
		response.setClienteVisibile(this.clienteService.deleteLogical(clienteService.getByCf(request.cfCliente).get()));      
		System.out.print(clienteService.getByCf(request.cfCliente).get().isVisibile());
		return response;
	}
	
}

package com.example.anagrafica.business;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;
import com.example.anagrafica.data.Indirizzo;
import com.example.anagrafica.data.IndirizzoCliente;
import com.example.anagrafica.data.IndirizzoClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	IndirizzoClienteRepository indirizzoClienteRepository;

	public Boolean create(Cliente cliente, Map<String, Indirizzo> indirizzi) {
		if (this.clienteRepository.existsByCf(cliente.getCf())) {
			return false;
		} else {
			Cliente clienteSaved = clienteRepository.save(cliente);
			IndirizzoCliente indirizzoCliente = null;

			for (String s : indirizzi.keySet()) {
				
				Indirizzo l = indirizzi.get(s);
				indirizzoCliente = new IndirizzoCliente(l, clienteSaved, s);
				indirizzoClienteRepository.save(indirizzoCliente);
			}
			return true;
		}
	}
	
	public Optional<Cliente> getClienteById(Integer id) {
		return this.clienteRepository.findById(id);
	}

	public Collection<Cliente> getAll() {
		return (Collection<Cliente>) this.clienteRepository.findAll();
	}

	public Boolean update(Cliente entity) {
		if (clienteRepository.existsById(entity.getId())) {
			Cliente savedCliente = this.clienteRepository.save(entity);
			return savedCliente != null;
		} else {
			return false;
		}
	}

	public Optional<Cliente> getById(int id) {
		Optional<Cliente> clienteById = clienteRepository.findById(id);
		return clienteById;
	}

	public Cliente getByCf(String cfCliente) {
		return clienteRepository.findByCf(cfCliente).get();
	}
}

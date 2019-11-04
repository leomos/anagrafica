package com.example.anagrafica.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
import com.example.anagrafica.utils.Utils;

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

	public Collection<Cliente> getAll() {
		return this.getAllVisibile(true);
	}

	public Optional<Cliente> getByCf(String string) {
		return this.clienteRepository.findByCf(string);
	}

	public Boolean update(Cliente entity) {
		if (clienteRepository.existsById(entity.getId())) {
			Cliente savedCliente = this.clienteRepository.save(entity);
			return savedCliente != null;
		} else {
			return false;
		}
	}

	public Boolean deleteLogical(Cliente entity) {
		if (entity.isVisibile()) {
			entity.setVisibile(false);
		}
		this.clienteRepository.save(entity);
		return entity.isVisibile();
	}

	public Collection<Cliente> getAllVisibile(boolean visibile) {
		return (Collection<Cliente>) this.clienteRepository.findAllByVisibile(visibile);
	}

	public Optional<Cliente> get(Integer id) {
		return this.clienteRepository.findById(id);
	}

	public Collection<Cliente> findWithFilter(ClienteFilter clienteFilter) throws Exception {

		Utils mt = new Utils();

		Collection<Cliente> CCli = this.getAll();
		System.out.println(CCli.toString());
		
		ArrayList<Cliente> nCCli=new ArrayList<Cliente>();
		for (Cliente c : CCli) {
			if (!clienteFilter.getNome().isEmpty()) {
				System.out.println(clienteFilter.getNome());
				System.out.println(c.getNome());
				if (c.getNome().equalsIgnoreCase(clienteFilter.getNome())) {
					nCCli.add(c);
				}
				;

			}
			;

			if (!clienteFilter.getCognome().isEmpty()) {
				if (c.getCognome().equalsIgnoreCase(clienteFilter.getCognome())) {
					nCCli.add(c);
				}
				;

			}
			;
			if (!clienteFilter.getSesso().isEmpty()) {
				if (c.getSesso().toString().equalsIgnoreCase(clienteFilter.getSesso())) {
					nCCli.add(c);
				}
				;

			}
			;
			if (!clienteFilter.getCf().isEmpty()) {
				if (c.getCf().equalsIgnoreCase(clienteFilter.getCf())) {
					nCCli.add(c);
				}
				;

			}
			;

			if (!clienteFilter.getDataIniziale().isEmpty()) {
				if (c.getDataDiNascita().compareTo(mt.dataCreator(clienteFilter.getDataIniziale())) >= 0) {
					nCCli.add(c);
				}
			}
			;
			if (!clienteFilter.getDataFinale().isEmpty()) {
				if (c.getDataDiNascita().compareTo(mt.dataCreator(clienteFilter.getDataFinale())) <= 0) {
					nCCli.add(c);
				}
			}
			;
			if (!clienteFilter.getProvinciaDiResidenza().isEmpty()) {
				boolean bic = false;
				for (IndirizzoCliente ic : c.getIndirizziClienti()) {
					if (ic.getIndirizzo().getProvincia().equalsIgnoreCase(clienteFilter.getProvinciaDiResidenza())) {
						bic = true;
					}
					;

				}
				;
				if (bic == true) {
					nCCli.add(c);
				}
			}
			;
			if (!clienteFilter.getRegioneDiResidenza().isEmpty()) {
				boolean bic = false;
				for (IndirizzoCliente ic : c.getIndirizziClienti()) {
					if (ic.getIndirizzo().getRegione().equalsIgnoreCase(clienteFilter.getRegioneDiResidenza())) {
						bic = true;
					}
					;

				}
				;
				if (bic == true) {
					nCCli.add(c);
				}
			}
			;
		}
		return nCCli;

	}

}

package com.example.anagrafica.data.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anagrafica.data.entities.Indirizzo;
import com.example.anagrafica.data.repositories.IndirizzoRepository;

@Service
public class IndirizzoService implements ServiceInterface<Indirizzo> {
	
	@Autowired
	IndirizzoRepository indirizzoRepository;

	public Boolean create(Indirizzo entity) {
		Indirizzo savedIndirizzo = this.indirizzoRepository.save(entity);
		return savedIndirizzo != null;
	}

	public Collection<Indirizzo> getAll() {
		return (Collection<Indirizzo>) this.indirizzoRepository.findAll();
	}

	public Boolean update(Indirizzo entity) {
		if(this.indirizzoRepository.existsById(entity.getId())) {
			Indirizzo savedIndirizzo = this.indirizzoRepository.save(entity);
			return savedIndirizzo != null;
		} else {
			return false;
		}
	}

	public Boolean delete(Integer id) {
		this.indirizzoRepository.deleteById(id);
		return true;
	}

	public Optional<Indirizzo> get(Integer id) {
		return this.indirizzoRepository.findById(id);
	}
	
}

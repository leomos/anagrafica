package com.example.anagrafica.data.services;

import java.util.Collection;
import java.util.Optional;

public interface ServiceInterface<E> {
	
	public Boolean create(E entity);
	
	public Collection<E> getAll();
	
	public Boolean update(E entity);
	
	public Boolean delete(Integer id);
	
	public Optional<E> get(Integer id);
	
}

package com.example.anagrafica.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	boolean existsByCf(String cf);
	
}

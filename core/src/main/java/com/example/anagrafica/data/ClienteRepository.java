package com.example.anagrafica.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	boolean existsByCf(String cf);
	Optional<Cliente> findByIdAndVisibileTrue(int id);
	List<Cliente> findAllByVisibileTrue();
	Optional<Cliente> findByCf(String string);
}

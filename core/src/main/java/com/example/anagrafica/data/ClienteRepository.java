package com.example.anagrafica.data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	public List<Cliente> findAllByNomeAndCognomeAndSessoAndCfAndDataDiNascitaBetweenAndLuogoDiNascitaAndMailAndTelefono
	(String nome,String cognome,char sesso,String cf,Date data1,Date data2,String luogoDiNascita,String mail,String telefono);
	
	boolean existsByCf(String cf);
	Optional<Cliente> findByIdAndVisibileTrue(int id);
	List<Cliente> findAllByVisibile(boolean visibile);

	Optional<Cliente> findByCf(String cfCliente);
	
	
}

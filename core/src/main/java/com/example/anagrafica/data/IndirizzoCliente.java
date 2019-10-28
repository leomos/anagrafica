package com.example.anagrafica.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IndirizzoCliente implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_indirizzo")
	private Indirizzo indirizzo;
	
	@Id
	private String tipo;
	
	public IndirizzoCliente() {}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}

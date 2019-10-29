package com.example.anagrafica.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class IndirizzoCliente implements Serializable {
	
	@EmbeddedId
	private IndirizzoClientePK id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("id_cliente")
	@JoinColumn(name="id_cliente", nullable = false, insertable = false, updatable = false)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("id_indirizzo")
	@JoinColumn(name="id_indirizzo", nullable = false, insertable = false, updatable = false)
	private Indirizzo indirizzo;
	
	public IndirizzoCliente() {}
	
	public IndirizzoCliente(Indirizzo indirizzo, Cliente cliente, String tipo) {
		IndirizzoClientePK icpk = new IndirizzoClientePK();
		icpk.setIdCliente(cliente.getId());
		icpk.setIdIndirizzo(indirizzo.getId());
		icpk.setTipo(tipo);
		this.id = icpk;
	}

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

	public IndirizzoClientePK getId() {
		return id;
	}

	public void setId(IndirizzoClientePK id) {
		this.id = id;
	}
	
}

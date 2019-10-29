package com.example.anagrafica.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IndirizzoClientePK implements Serializable {
	
	@Column(name="id_cliente")
	private Integer idCliente;
	
	@Column(name="id_indirizzo")
	private Integer idIndirizzo;
	
	@Column(name="tipo")
	private String tipo;
	
	public IndirizzoClientePK() {}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdIndirizzo() {
		return idIndirizzo;
	}

	public void setIdIndirizzo(Integer idIndirizzo) {
		this.idIndirizzo = idIndirizzo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idIndirizzo == null) ? 0 : idIndirizzo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndirizzoClientePK other = (IndirizzoClientePK) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (idIndirizzo == null) {
			if (other.idIndirizzo != null)
				return false;
		} else if (!idIndirizzo.equals(other.idIndirizzo))
			return false;
		return true;
	}
	
}

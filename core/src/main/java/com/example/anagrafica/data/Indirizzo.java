package com.example.anagrafica.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Indirizzo {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private String luogo;
	
	private Integer numero_civico;
	
	private String citta;
	
	private String provincia;
	
	private String regione;
	
	private String nazione;
	
	public Indirizzo(Integer id, 
			String luogo, 
			Integer numero_civico, 
			String citta, 
			String provincia, 
			String regione,
			String nazione) {
		super();
		this.id = id;
		this.luogo = luogo;
		this.numero_civico = numero_civico;
		this.citta = citta;
		this.provincia = provincia;
		this.regione = regione;
		this.nazione = nazione;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public Integer getNumero_civico() {
		return numero_civico;
	}

	public void setNumero_civico(Integer numero_civico) {
		this.numero_civico = numero_civico;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

}

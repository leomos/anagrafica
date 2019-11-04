package com.example.anagrafica.business;

import java.util.Date;

import javax.persistence.Column;

public class ClienteFilter {

	

	
	private String nome;
	
	private String cognome;
	
	private String sesso;
	
	private String cf;
	
	
	private String dataIniziale;
	
	private String dataFinale;
	
	
	
	private String provinciaDiResidenza;
	
	private String regioneDiResidenza;

	public ClienteFilter(String nome, String cognome, String sesso, String cf, String dataIniziale, String dataFinale,
			String provinciaDiResidenza, String regioneDiResidenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.cf = cf;
		this.dataIniziale = dataIniziale;
		this.dataFinale = dataFinale;
		this.provinciaDiResidenza = provinciaDiResidenza;
		this.regioneDiResidenza = regioneDiResidenza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getDataIniziale() {
		return dataIniziale;
	}

	public void setDataIniziale(String dataIniziale) {
		this.dataIniziale = dataIniziale;
	}

	public String getDataFinale() {
		return dataFinale;
	}

	public void setDataFinale(String dataFinale) {
		this.dataFinale = dataFinale;
	}

	public String getProvinciaDiResidenza() {
		return provinciaDiResidenza;
	}

	public void setProvinciaDiResidenza(String provinciaDiResidenza) {
		this.provinciaDiResidenza = provinciaDiResidenza;
	}

	public String getRegioneDiResidenza() {
		return regioneDiResidenza;
	}

	public void setRegioneDiResidenza(String regioneDiResidenza) {
		this.regioneDiResidenza = regioneDiResidenza;
	}


	
	
	
	
}

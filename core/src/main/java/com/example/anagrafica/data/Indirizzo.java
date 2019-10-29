package com.example.anagrafica.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Indirizzo {
	
	@Override
	public String toString() {
		return "Indirizzo [id=" + id + ", luogo=" + luogo + ", numeroCivico=" + numeroCivico + ", citta=" + citta
				+ ", provincia=" + provincia + ", regione=" + regione + ", nazione=" + nazione + ", indirizziClienti="
				+ indirizziClienti + "]";
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	private String luogo;

	@Column(name="numero_civico")
	private Integer numeroCivico;
	
	private String citta;
	
	private String provincia;
	
	private String regione;
	
	private String nazione;
	
	@OneToMany(mappedBy="indirizzo")
	Set<IndirizzoCliente> indirizziClienti;
	
	public Indirizzo(String luogo, 
			Integer numeroCivico, 
			String citta, 
			String provincia, 
			String regione,
			String nazione) {
		super();
		this.luogo = luogo;
		this.numeroCivico = numeroCivico;
		this.citta = citta;
		this.provincia = provincia;
		this.regione = regione;
		this.nazione = nazione;
	}
	
	public Indirizzo() {}

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

	public Integer getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(Integer numeroCivico) {
		this.numeroCivico = numeroCivico;
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

package com.example.anagrafica.data;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private String cognome;
	
	private Character sesso;
	
	private String cf;
	
	@Column(name="data_di_nascita")
	private Date dataDiNascita;
	
	@Column(name="luogo_di_nascita")
	private String luogoDiNascita;
	
	private String mail;
	
	private String telefono;
	
	@OneToMany
	@JoinTable(
			name="indirizzo_cliente",
			joinColumns = @JoinColumn(
	                name = "id_cliente",
	                referencedColumnName = "id"
	        ),
	        inverseJoinColumns = @JoinColumn(
	                name = "id_indirizzo",
	                referencedColumnName = "id"
	        )
	)
	private Collection<Indirizzo> indirizzi;
	
	@OneToMany(mappedBy = "cliente", targetEntity = IndirizzoCliente.class)
	private Collection<IndirizzoCliente> indirizziClienti;
	
	private Cliente() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Character getSesso() {
		return sesso;
	}

	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Collection<Indirizzo> getIndirizzi() {
		return indirizzi;
	}

	public void setIndirizzi(Collection<Indirizzo> indirizzi) {
		this.indirizzi = indirizzi;
	}

	public Collection<IndirizzoCliente> getIndirizziClienti() {
		return indirizziClienti;
	}

	public void setIndirizziClienti(Collection<IndirizzoCliente> indirizziClienti) {
		this.indirizziClienti = indirizziClienti;
	}
	
	
}

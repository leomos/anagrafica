package com.example.anagrafica.data;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	/*@OneToMany
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
	private Collection<Indirizzo> indirizzi;*/
	

	@OneToMany(mappedBy = "cliente", fetch=FetchType.EAGER)
	private Set<IndirizzoCliente> indirizziClienti;
	
	public Cliente() {}

	public Cliente(String nome, String cognome, Character sesso, String cf, Date dataDiNascita,
			String luogoDiNascita, String mail, String telefono) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.cf = cf;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
		this.mail = mail;
		this.telefono = telefono;
	}
	
	public Cliente(String nome, String cognome, Character sesso, String cf, Date dataDiNascita,
			String luogoDiNascita, String mail, String telefono,
			Map<String, Indirizzo> indirizzi) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.cf = cf;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
		this.mail = mail;
		this.telefono = telefono;
		
		Indirizzo residenza = indirizzi.get("residenza");
		
	}


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

	/*
	public Collection<Indirizzo> getIndirizzi() {
		return indirizzi;
	}

	public void setIndirizzi(Collection<Indirizzo> indirizzi) {
		this.indirizzi = indirizzi;
	}*/

	public Set<IndirizzoCliente> getIndirizziClienti() {
		return indirizziClienti;
	}

	public void setIndirizziClienti(Set<IndirizzoCliente> indirizziClienti) {
		this.indirizziClienti = indirizziClienti;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", cf=" + cf
				+ ", dataDiNascita=" + dataDiNascita + ", luogoDiNascita=" + luogoDiNascita + ", mail=" + mail
				+ ", telefono=" + telefono + "]";
	}
	
	
}

package com.example.anagrafica.data;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
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
	
	private Boolean visibile=true;
	
	public Boolean isVisibile() {
		return visibile;
	}

	public void setVisibile(Boolean visibile) {
		this.visibile = visibile;
	}

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
		this.indirizziClienti=new HashSet<IndirizzoCliente>();
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
		this.indirizziClienti=new HashSet<IndirizzoCliente>();
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

	public Set<IndirizzoCliente> getIndirizziClienti() {
		return indirizziClienti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cf == null) ? 0 : cf.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((luogoDiNascita == null) ? 0 : luogoDiNascita.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sesso == null) ? 0 : sesso.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((visibile == null) ? 0 : visibile.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cf == null) {
			if (other.cf != null)
				return false;
		} else if (!cf.equals(other.cf))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataDiNascita == null) {
			if (other.dataDiNascita != null)
				return false;
		} else if (!dataDiNascita.equals(other.dataDiNascita))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (luogoDiNascita == null) {
			if (other.luogoDiNascita != null)
				return false;
		} else if (!luogoDiNascita.equals(other.luogoDiNascita))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sesso == null) {
			if (other.sesso != null)
				return false;
		} else if (!sesso.equals(other.sesso))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (visibile == null) {
			if (other.visibile != null)
				return false;
		} else if (!visibile.equals(other.visibile))
			return false;
		return true;
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

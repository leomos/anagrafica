package data;

import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.Indirizzo;

public class NewCliente {
private Cliente cliente;
private String dataDiNascita;
private Indirizzo indirizzoResidenza;
private Indirizzo indirizzoDomicilio;
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public Indirizzo getIndirizzoResidenza() {
	return indirizzoResidenza;
}
public void setIndirizzoResidenza(Indirizzo indirizzoResidenza) {
	this.indirizzoResidenza = indirizzoResidenza;
}
public Indirizzo getIndirizzoDomicilio() {
	return indirizzoDomicilio;
}
public void setIndirizzoDomicilio(Indirizzo indirizzoDomicilio) {
	this.indirizzoDomicilio = indirizzoDomicilio;
}
public NewCliente(Cliente cliente, Indirizzo indirizzoResidenza, Indirizzo indirizzoDomicilio) {
	super();
	this.cliente = cliente;
	this.indirizzoResidenza = indirizzoResidenza;
	this.indirizzoDomicilio = indirizzoDomicilio;
}
public String getDataDiNascita() {
	return dataDiNascita;
}
public void setDataDiNascita(String dataDiNascita) {
	this.dataDiNascita = dataDiNascita;
}

}

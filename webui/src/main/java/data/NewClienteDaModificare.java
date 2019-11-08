package data;

import com.example.anagrafica.data.Cliente;

public class NewClienteDaModificare {
	private Cliente cliente;
	private String dataDiNascita;

	public NewClienteDaModificare(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

}

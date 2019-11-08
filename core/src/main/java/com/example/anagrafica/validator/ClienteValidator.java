package com.example.anagrafica.validator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Optional;

import org.apache.logging.log4j.spi.CleanableThreadContextMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.anagrafica.data.Cliente;

public class ClienteValidator implements Validator {

	

	public boolean supports(Class clazz) {

		return Cliente.class.equals(clazz);
	}

	public void validate(Object cliente, Errors e) {
		
		ValidationUtils.rejectIfEmpty(e, "nome", "nome.empty");
		ValidationUtils.rejectIfEmpty(e, "cognome", "cognome.empty");
		ValidationUtils.rejectIfEmpty(e, "sesso", "sesso.empty");
		ValidationUtils.rejectIfEmpty(e, "cf", "cf.empty");
		ValidationUtils.rejectIfEmpty(e, "dataDiNascita", "dataDiNascita.empty");
		ValidationUtils.rejectIfEmpty(e, "luogoDiNascita", "luogoDiNascita.empty");
		ValidationUtils.rejectIfEmpty(e, "mail", "mail.empty");
		ValidationUtils.rejectIfEmpty(e, "telefono", "telefono.empty");
	
		Cliente cli=(Cliente) cliente;		
		if(!cli.getSesso().equals('M') && !cli.getSesso().equals('m') && !cli.getSesso().equals('f') && !cli.getSesso().equals('F')&& !cli.getSesso().equals('u') && !cli.getSesso().equals('U')) {
		e.rejectValue("sesso", "non è m/f o u.");
	}
	if(cli.getCf().length() !=16 ) {
		e.rejectValue("cf", "non è di 16 caratteri");
	}
	if(cli.getDataDiNascita().after(Calendar.getInstance().getTime())) {
		e.rejectValue("dataDiNascita", "è nato nel futuro?");
	}
	if(cli.getTelefono().charAt(0)!='+' && Character.isDigit(cli.getTelefono().charAt(0))) {
		e.rejectValue("telefono", "il primo carattere deve essere un numero o il +");
	}
	
	char [] c=new char[cli.getTelefono().length()];
	cli.getTelefono().getChars(1, cli.getTelefono().length(),c, 0);
	for(char ca:c) {
		if (!Character.isDigit(ca)) {
			
			e.rejectValue("telefono", "il carattere "+ca+" deve essere un numero");
		}
	}
	
	
	}

}

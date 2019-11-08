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

		Cliente cli = (Cliente) cliente;
		if (!Optional.ofNullable(cli.getNome()).isPresent() || Optional.ofNullable(cli.getNome()).get().isEmpty()) {

			e.rejectValue("nome", "nome nullo");
		}

		if (Optional.ofNullable(cli.getCognome()) == null || Optional.ofNullable(cli.getCognome()).get().isEmpty()) {

			e.rejectValue("cognome", "cognome nullo");
		}

		if (Optional.ofNullable(cli.getSesso()) == null || !Optional.ofNullable(cli.getSesso()).isPresent()) {

			e.rejectValue("sesso", "sesso nullo");
		}

		if (Optional.ofNullable(cli.getCf()) == null || !Optional.ofNullable(cli.getCf()).isPresent()) {
			e.rejectValue("cf", "cf nullo");
		}

		if (Optional.ofNullable(cli.getDataDiNascita()) == null
				|| !Optional.ofNullable(cli.getDataDiNascita()).isPresent()) {

			e.rejectValue("dataDiNascita", "data di nascita nulla");
		}

		if (Optional.ofNullable(cli.getLuogoDiNascita()) == null
				|| Optional.ofNullable(cli.getLuogoDiNascita()).get().isEmpty()) {

			e.rejectValue("luogoDiNascita", " luogo di nascita nullo");
		}

		if (Optional.ofNullable(cli.getMail()) == null || Optional.ofNullable(cli.getMail()).get().isEmpty()) {

			e.rejectValue("mail", "mail nulla");
		}

		if (Optional.ofNullable(cli.getCf()) == null || Optional.ofNullable(cli.getTelefono()).get().isEmpty()) {

			e.rejectValue("telefono", "telefono nullo");
		}
		if (Optional.ofNullable(cli.getSesso()).isPresent()) {
			if (!Optional.ofNullable(cli.getSesso()).get().equals('M')
					&& !Optional.ofNullable(cli.getSesso()).get().equals('m')
					&& !Optional.ofNullable(cli.getSesso()).get().equals('f')
					&& !Optional.ofNullable(cli.getSesso()).get().equals('F')
					&& !Optional.ofNullable(cli.getSesso()).get().equals('u')
					&& !Optional.ofNullable(cli.getSesso()).get().equals('U')) {
				e.rejectValue("sesso", "i sesso non è m/f o u.");

			}
		}
//		if (cli.getCf().length() != 16) {
//			e.rejectValue("cf", "il cf non è di 16 caratteri");
//
//		}
		if (Optional.ofNullable(cli.getDataDiNascita()).isPresent()) {

			if (cli.getDataDiNascita().after(Calendar.getInstance().getTime())) {
				e.rejectValue("dataDiNascita", "è nato nel futuro?");
			}
		}

		if (Optional.ofNullable(cli.getTelefono()).get().length() != 0) {
			if (cli.getTelefono().charAt(0) != '+' && Character.isDigit(cli.getTelefono().charAt(0))) {
				e.rejectValue("telefono", "il primo carattere del telefono deve essere un numero o il +");

			}

			char[] c = new char[cli.getTelefono().length()];
			cli.getTelefono().getChars(1, cli.getTelefono().length(), c, 0);
			for (int i = 0; i < c.length - 1; i++) {
				char ca = c[i];

				try {
					System.out.println("i" + String.valueOf(ca) + "I");
					int testParse = Integer.parseInt(String.valueOf(ca));
				} catch (Exception err) {
					if (Optional.ofNullable(ca) != null) {
						e.rejectValue("telefono",
								" il carattere del telefono inserito : " + ca + " deve essere un numero");
					}
				}
			}

		}

	}

}

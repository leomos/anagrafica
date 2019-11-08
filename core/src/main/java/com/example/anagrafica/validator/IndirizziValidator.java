package com.example.anagrafica.validator;

import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.Indirizzo;

public class IndirizziValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Indirizzo.class.equals(clazz);
	}

	public void validate(Object indirizzo, Errors e) {

		Indirizzo ind=(Indirizzo)indirizzo;
if (!Optional.ofNullable(ind.getLuogo()).isPresent() || Optional.ofNullable(ind.getLuogo()).get().isEmpty() ) {
			
			e.rejectValue("luogo", "Luogo nullo"); }
		

if (!Optional.ofNullable(ind.getNumeroCivico()).isPresent()   )  {
	
	
	e.rejectValue("numeroCivico", "nullo"); }

if (!Optional.ofNullable(ind.getCitta()).isPresent() || Optional.ofNullable(ind.getCitta()).get().isEmpty() ) {
	
	e.rejectValue("citta", "Città nulla"); }

if (!Optional.ofNullable(ind.getProvincia()).isPresent() || Optional.ofNullable(ind.getProvincia()).get().isEmpty() ) {
	
	e.rejectValue("provicia", "provincia nulla"); }

if (!Optional.ofNullable(ind.getRegione()).isPresent() || Optional.ofNullable(ind.getRegione()).get().isEmpty() ) {
	
	e.rejectValue("regione", "regione nulla"); }

if (!Optional.ofNullable(ind.getNazione()).isPresent() || Optional.ofNullable(ind.getNazione()).get().isEmpty() ) {
	
	e.rejectValue("nazione", "nazione nulla"); }

	

if(Optional.ofNullable(ind.getProvincia()).isPresent()) {
	if (ind.getProvincia().length() !=2) {
		e.rejectValue("provicia", "provincia errata");
	}
	
	if(Optional.ofNullable(ind.getCitta()).isPresent()) {
	    char [] ca=    ind.getCitta().toCharArray();
	    for(char c:ca) {
	    	try {
	    		Integer.parseInt(String.valueOf(c));
	    		e.rejectValue("citta", "numeri non consentiti in città");
	    	}catch(Exception exc){}
	    	
	    }}
		if(Optional.ofNullable(ind.getRegione()).isPresent()) {
		    char [] ca=    ind.getRegione().toCharArray();
		    for(char c:ca) {
		    	try {
		    		Integer.parseInt(String.valueOf(c));
		    		e.rejectValue("regione", "numeri non consentiti in regione");
		    	}catch(Exception exc){}
		    	
		    }}
		if(Optional.ofNullable(ind.getNazione()).isPresent()) {
		    char [] ca=    ind.getNazione().toCharArray();
		    for(char c:ca) {
		    	try {
		    		Integer.parseInt(String.valueOf(c));
		    		e.rejectValue("nazione", "numeri non consentiti in nazione");
		    	}catch(Exception exc){}
		    	
		    }}
		if(Optional.ofNullable(ind.getLuogo()).isPresent()) {
		    char [] ca=    ind.getLuogo().toCharArray();
		    for(char c:ca) {
		    	try {
		    		Integer.parseInt(String.valueOf(c));
		    		e.rejectValue("luogo", "numeri non consentiti in luogo");
		    	}catch(Exception exc){}
		    	
		    }}
	
}





		}}
		
	



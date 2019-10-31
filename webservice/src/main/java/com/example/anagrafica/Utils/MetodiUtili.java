package com.example.anagrafica.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MetodiUtili {
	public Date dataCreator(String args) throws Exception {

		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(args);

		return date1;
	}

	
	
	
}

package com.example.anagrafica.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public Date dataCreator(String args) throws Exception {

		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(args);

		return date1;
	}

	
	public static String dataToString(Date data) {
		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(data);
		System.out.println(date);
		
		return date ;
		
	}
	
	
	
}

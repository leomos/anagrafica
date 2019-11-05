package com.example.anagrafica.utils;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.business.IndirizzoService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UtilsTest {
	
	@TestConfiguration
	static class UtilsTestContextConfiguration {
		@Bean
        public Utils utils() {
            return new Utils();
        }
		
		@Bean
        public ClienteService clienteService() {
            return new ClienteService();
        }
		
	
		
	
	}
	
@Autowired
private Utils utils;
@Autowired
private ClienteService clienteService;
@Autowired
private ClienteRepository clienteRepository;

	@Test
	public void checkdataToStringUtils() throws Exception {
		
		Cliente c2 = new Cliente();
		try {
			c2 = new Cliente("ALeonardo", "Blu", 'M', "ARRSS0112DD23", utils.dataCreator("01/08/1994"), "Roma",
					"mario.rossi@example.com", "+39111222333");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		clienteRepository.save(c2);
		String sdata2=Utils.dataToString(c2.getDataDiNascita());
		
	Date	data1 =utils.dataCreator("15/01/1994");
	String sdata1 =Utils.dataToString(data1);
		
	
		Date data3= clienteService.getByCf("ARRSS0112DD23").get().getDataDiNascita();
	
		String sdata3= Utils.dataToString(data3);
	
	
		assertTrue(sdata1.equals("15/01/1994") && sdata2.equals("01/08/1994") && sdata3.equals("01/08/1994") );
	
	
		
	}




}
	
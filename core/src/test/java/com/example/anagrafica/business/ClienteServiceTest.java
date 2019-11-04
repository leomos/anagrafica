package com.example.anagrafica.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;
import com.example.anagrafica.data.Indirizzo;
import com.example.anagrafica.data.IndirizzoClienteRepository;
import com.example.anagrafica.data.IndirizzoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteServiceTest {
	
	@TestConfiguration
	static class ClienteServiceTestContextConfiguration {
		@Bean
        public ClienteService clienteService() {
            return new ClienteService();
        }
		
		@Bean
        public IndirizzoService indirizzoService() {
            return new IndirizzoService();
        }
	}
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private IndirizzoService indrizzoService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private IndirizzoClienteRepository indirizzoClienteRepository;
	
	@Autowired
	private IndirizzoRepository indirizzoRepository;
	
	@Before
	public void setUp() {
	   
	}
	
	private void stampaClienti() {
	    for(Cliente c : this.clienteService.getAll()) {
	    	System.out.println(c);
	    }
	}
	
	@Test
	public void checkGet_whenIdisnotPresent() {
	    int k=8;
	    int j=1;
	    int l=3;
	    assertTrue(this.clienteService.get(j).isPresent());
	    assertTrue(this.clienteService.get(l).isPresent());
	    assertFalse(this.clienteService.get(k).isPresent());
	    this.stampaClienti();
	}
	
	@Test
	public void checkUpdate_whenIdisnotPresent() {
		Cliente c2 = new Cliente(
	    		"Alex",
	    		"Rossi",
	    		'M',
	    		"safafv",
	    		new Date(),
	    		"Roma",
	    		"mario.rossi@example.com",
	    		"+39111222333"
	    );
		c2.setId(8);
	    System.out.println("U1: " + this.clienteRepository.count());
		this.stampaClienti();
	    assertFalse(clienteService.update(c2));
	    c2.setId(3);
	    System.out.println("U2: " + this.clienteRepository.count());
	    assertTrue(clienteService.update(c2)); 
	    
	    
	}
	
	
	@Test
	public void checkSetIdForUpdate() {
		Cliente c1 = new Cliente(
	    		"Alex",
	    		"Rossi",
	    		'M',
	    		"fsfwfec",
	    		new Date(),
	    		"Roma",
	    		"mario.rossi@example.com",
	    		"+39111222333"
	    );
		assertTrue(c1.getId() == null);
		c1.setId(2);
	    assertTrue(c1.getId()==2);	  
	}	
}

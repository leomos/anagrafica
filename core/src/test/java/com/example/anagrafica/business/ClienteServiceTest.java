package com.example.anagrafica.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.h2.engine.SysProperties;
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
import com.example.anagrafica.utils.Utils;

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
	

	Utils utils = new Utils();

	@Before
	public void setUp() {
		Cliente c1 = new Cliente();
		try {
			c1 = new Cliente("Mario", "Rossi", 'M', "MARRSS0112DD23", utils.dataCreator("01/08/2018"), "Roma",
					"mario.rossi@example.com", "+39111222333");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Cliente c2 = new Cliente();
		try {
			c2 = new Cliente("ALeonardo", "Blu", 'M', "ARRSS0112DD23", utils.dataCreator("01/08/1994"), "Roma",
					"mario.rossi@example.com", "+39111222333");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Indirizzo i1 = new Indirizzo("Via Rossi", 55, "Roma", "Roma", "Lazio", "Italia");

		Indirizzo i2 = new Indirizzo("Via Viola", 55, "Roma", "Roma", "Lazio", "Italia");

		this.indrizzoService.create(i1);
		this.indrizzoService.create(i2);

		Map<String, Indirizzo> mappaIndirizzi = new HashMap<String, Indirizzo>();
		mappaIndirizzi.put("residenza", i1);
		Map<String, Indirizzo> mappaIndirizzi2 = new HashMap<String, Indirizzo>();
		mappaIndirizzi2.put("residenza", i2);

		clienteService.create(c1, mappaIndirizzi);
		clienteService.create(c2, mappaIndirizzi2);
		System.out.println(clienteRepository.count());
		System.out.println(clienteService.getAll().toString());
		// System.out.println("Indirizzi"+ indrizzoService.getAll().toString());
	}

	@Test
	public void checkeExistsByCf_whenExistingCf_ClienteShouldNotBeCreated() {
		Cliente c1 = new Cliente("Mario", "Rossi", 'M', "MARRSS0112DD23", new Date(), "Roma", "mario.rossi@example.com",
				"+39111222333");

		Indirizzo i1 = new Indirizzo("Via Rossi", 55, "Roma", "Roma", "Lazio", "Italia");

		this.indrizzoService.create(i1);

		Map<String, Indirizzo> mappaIndirizzi = new HashMap<String, Indirizzo>();
		mappaIndirizzi.put("residenza", i1);

		assertFalse(clienteService.create(c1, mappaIndirizzi));
	}

	@Test
	public void checkFindWithFilterName_whenExistName_ShouldReturnCliente() throws Exception {
		ClienteFilter clFilter = new ClienteFilter("ALeonardo", "", "", "", "", "", "", "");
		Collection<Cliente> clFiltered = null;
		clFiltered = clienteService.findWithFilter(clFilter);
		int dimensioneFilter = clFiltered.size();
		assertEquals(2, dimensioneFilter);

	}

	@Test
	public void checkFindWithFilterName_whenNoExistName_ShouldReturnNoCliente() throws Exception {
		ClienteFilter clFilter = new ClienteFilter("Domitilla", "", "", "", "", "", "", "");
		Collection<Cliente> clFiltered = clienteService.findWithFilter(clFilter);
		int dimensioneFilter = clFiltered.size();

		assertEquals(0, dimensioneFilter);

	}

	@Test
	public void checkFindWithFilterRegione_whenExistRegione_ShouldReturnCliente() throws Exception {
		ClienteFilter clFilter = new ClienteFilter("", "", "", "", "", "", "", "Lombardia");
		Collection<Cliente> clFiltered = clienteService.findWithFilter(clFilter);
		int dimensioneFilter = clFiltered.size();
		assertEquals(1, dimensioneFilter);

	}

	@Test
	public void checkFindWithFilterDate_whenDateInterval_ShouldReturnCliente() throws Exception {
		ClienteFilter clFilter = new ClienteFilter("", "", "", "", "01/01/1993", "01/01/1995", "", "");
		Collection<Cliente> clFiltered = clienteService.findWithFilter(clFilter);
		int dimensioneFilter = clFiltered.size();
		assertEquals(1, dimensioneFilter);

	}

	@Test
	public void checkegetAllVisibile_whenSearchVisibileTrue_ShouldFindExactNumber() {

		Cliente c1 = new Cliente("Mario", "Rossi", 'M', "MARRSS0331233", new Date(), "Roma", "mario.rossi@example.com",
				"+39111222333");
		Indirizzo i1 = new Indirizzo("Via Rossi", 55, "Roma", "Roma", "Lazio", "Italia");
		Cliente c2 = new Cliente("Mario", "Rossi", 'M', "MARRS1S01331233", new Date(), "Roma",
				"mario.rossi@example.com", "+39111222333");
		Cliente c3 = new Cliente("Mario", "Rossi", 'M', "MARRS1S0441233", new Date(), "Roma", "mario.rossi@example.com",
				"+39111222333");
		this.indrizzoService.create(i1);
		c1.setVisibile(true);
		Map<String, Indirizzo> mappaIndirizzi = new HashMap<String, Indirizzo>();
		mappaIndirizzi.put("domicilio", i1);

		c1.setVisibile(true);
		c3.setVisibile(true);
		c2.setVisibile(true);
		clienteService.create(c1, mappaIndirizzi);
		clienteRepository.save(c2);
		clienteRepository.save(c3);

		int i = clienteService.getAllVisibile(true).size();

		c3.setVisibile(false);
		c2.setVisibile(false);
		System.out.println("numero visibili trovati " + clienteService.getAllVisibile(true).size());

		assertTrue((i - clienteService.getAllVisibile(true).size()) == 2);
	}

	@Test
	public void checkFindWithFilterDate_whenNoDateInInterval_ShouldNotReturnCliente() throws Exception {
		ClienteFilter clFilter = new ClienteFilter("", "", "", "", "01/01/2019", "31/01/2020", "", "");
		Collection<Cliente> clFiltered = clienteService.findWithFilter(clFilter);
		int dimensioneFilter = clFiltered.size();
		assertEquals(0, dimensioneFilter);

	}

	@Test
	public void checkfindWithFilter_cf_whenClienteIsNotVisibile_dontShow() {
		
		Cliente c = clienteService.get(1).get();
		
		System.out.println("");
		System.out.println(c.toString());
		System.out.println("");
		
		ClienteFilter clf = new ClienteFilter("","","",	c.getCf(),"","","","");

		this.clienteService.deleteLogical(c);
			
		try {
			assertTrue(clienteService.findWithFilter(clf).isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

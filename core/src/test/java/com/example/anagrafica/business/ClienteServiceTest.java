package com.example.anagrafica.business;

import static org.junit.Assert.assertEquals;
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
		Cliente c1 = new Cliente("Mario", "Rossi", 'M', "MARRSS0112DD23", new Date(), "Roma", "mario.rossi@example.com",
				"+39111222333");

		Indirizzo i1 = new Indirizzo("Via Rossi", 55, "Roma", "Roma", "Lazio", "Italia");

		this.indrizzoService.create(i1);

		Map<String, Indirizzo> mappaIndirizzi = new HashMap<String, Indirizzo>();
		mappaIndirizzi.put("residenza", i1);

		clienteService.create(c1, mappaIndirizzi);
		System.out.println(indirizzoRepository.count());
		System.out.println(clienteRepository.count());
	}

	@Test
	public void checkeExistsByCf_whenExistingCf_ClienteShouldNotBeCreated() {
		Cliente c1 = new Cliente("Mario", "Rossi", 'M', "MARRSS0112DD24", new Date(), "Roma", "mario.rossi@example.com",
				"+39111222333"

		);

		Indirizzo i1 = new Indirizzo("Via Rossi", 55, "Roma", "Roma", "Lazio", "Italia");

		this.indrizzoService.create(i1);

		Map<String, Indirizzo> mappaIndirizzi = new HashMap<String, Indirizzo>();
		mappaIndirizzi.put("residenza", i1);

		assertTrue(clienteService.create(c1, mappaIndirizzi));

		System.out.println(clienteRepository.count());
		System.out.println(indirizzoRepository.count());
	}

	@Test
	public void checkGetAll_whenGetAll_returnNumberOfClienti() {

		System.out.println(clienteRepository.count());
		System.out.println(indirizzoRepository.count());
		assertEquals(clienteService.getAll().size(), 4);

	}

	@Test
	public void checkGetByCf_whenGetCliente_returnName() {
		Cliente c1 = new Cliente("Gianni", "Rossi", 'M', "MARRSS0112DD22", new Date(), "Roma",
				"mario.rossi@example.com", "+39111222333"

		);
		Indirizzo i1 = new Indirizzo("Via Rossi", 55, "Roma", "Roma", "Lazio", "Italia");

		this.indrizzoService.create(i1);

		Map<String, Indirizzo> mappaIndirizzi = new HashMap<String, Indirizzo>();
		mappaIndirizzi.put("residenza", i1);

		assertTrue(clienteService.create(c1, mappaIndirizzi));
		System.out.println(clienteRepository.count());
		System.out.println(indirizzoRepository.count());
		assertEquals(this.clienteService.getByCf("MARRSS0112DD22").get().getNome(), c1.getNome());

	}

	@Test
	public void checkDeleteLogicale_whenDeletedOne_visibileIsSetFalse() {
		Cliente c1 = new Cliente("Gianni", "Rossi", 'M', "MARRSS0112DD21", new Date(), "Roma",
				"mario.rossi@example.com", "+39111222333"

		);
		Indirizzo i1 = new Indirizzo("Via Rossi", 55, "Roma", "Roma", "Lazio", "Italia");

		this.indrizzoService.create(i1);

		Map<String, Indirizzo> mappaIndirizzi = new HashMap<String, Indirizzo>();
		mappaIndirizzi.put("residenza", i1);

		assertTrue(clienteService.create(c1, mappaIndirizzi));
		this.clienteService.deleteLogical(c1);

		assertFalse(this.clienteService.getByCf("MARRSS0112DD21").get().isVisibile());

	}

	@Test
	public void checkDeleteLogicale_whenDeleteClienteNotInDatabase_clienteNotAdded() {
		Cliente c2 = new Cliente("Gianni", "Rossi", 'M', "MARRSS02DD", new Date(), "Roma", "mario.rossi@example.com",
				"+39111222333"

		);
		c2.setId(1);
		int i = (int) clienteRepository.count();

		this.clienteService.deleteLogical(c2);

		assertEquals((int) this.clienteRepository.count(), i);

	}

}

package locationAPI.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import locationAPI.example.model.Client;
import locationAPI.web.dao.ClientDao;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class ClientControler {

	private final ClientDao clientDao;

	public ClientControler(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@GetMapping("/clients")
	public MappingJacksonValue listAllClients() {
		List<Client> clients = clientDao.findAll();
		SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("animal");
		FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
		MappingJacksonValue clientsFiltres = new MappingJacksonValue(clients);
		clientsFiltres.setFilters(listDeNosFiltres);
		return clientsFiltres;
	}

	@GetMapping("/clients/{id}")
	public Client afficherCLient(@PathVariable String id) {
		return clientDao.findById(id);
	}

	@PostMapping(value = "/clients")
	public ResponseEntity<Client> ajouterClient(@RequestBody Client client) {
		Client clientadded = clientDao.save(client);
		if (Objects.isNull(clientadded)) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(clientadded.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(value = "/clients/{id}")
	public Client supprimerClient(@PathVariable String id) {
		return clientDao.remove(id);
	}

	@PutMapping(value = "/clients")
	public Client updateClient(@RequestBody Client client) {
		return clientDao.update(client);
	}
}

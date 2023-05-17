package locationAPI.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import locationAPI.example.model.Client;
import locationAPI.web.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ClientControler {

	@Autowired
	private final ClientDao clientDao;

	public ClientControler(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@GetMapping("/clients")
	public MappingJacksonValue listAllClients() {
		Iterable<Client> clients = clientDao.findAll();
//		List<Client> clients = clientDao.findAll();
		SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("animal");
		FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
		MappingJacksonValue clientsFiltres = new MappingJacksonValue(clients);
		clientsFiltres.setFilters(listDeNosFiltres);
		return clientsFiltres;
	}

	@GetMapping(value = "/clients/{id}")
	public Optional<Client> afficherUnCLient(@PathVariable String id) {
		return clientDao.findById(id);
	}

//
//	@GetMapping("/clients/{id}")
//	public Client afficherCLient(@PathVariable String id) {
//		return clientDao.findById(id);
//	}
//
	@PostMapping(value = "/clients")
	public ResponseEntity<Client> ajouterClient(@RequestBody Client client) {
		Client clientadded = clientDao.save(client);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(clientadded.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(value = "/clients/{id}")
	public void supprimerClient(@PathVariable String id) {
		clientDao.deleteById(id);
	}

	@PutMapping (value = "/clients")
	public void updateProduit(@RequestBody Client client)
	{
		clientDao.save(client);
	}

//	@GetMapping (value = "/test/{animal}")
//	public Client test(@PathVariable String animal){
//		return (Client) clientDao.findByAnimal(animal);
//	}
//	@ExceptionHandler(ClientNotFoundException.class)
//	public ResponseEntity<Object> handleClientNotFoundException(ClientNotFoundException ex) {
//		return ResponseEntity.status(HttpStatus.NOT_FOUND)
//				.body("{\"message\":\"" + ex.getMessage() + "\"}");
//	}
}

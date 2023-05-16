package locationAPI.web.controller;

import com.github.javafaker.Faker;
import locationAPI.example.model.Client;
import locationAPI.example.model.FakeDataGenerator;
import locationAPI.web.dao.ClientDao;
import locationAPI.web.dao.ClientDaolmpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ClientControler {

	private final ClientDao clientDao;
	public ClientControler(ClientDao clientDao){
		this.clientDao = clientDao;
	}

	@GetMapping("/clients")
	public List<Client> listClient() {
		return clientDao.findAll();
	}

	@GetMapping("/clients/{id}")
	public Client afficherUnCLient(@PathVariable String id) {
		return clientDao.findById(id);
	}
//	public List<Client> afficherUnclient(@PathVariable int id) {
//		Faker faker = new Faker();
//		List<Client> clients = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			Client client = new Client();
//			client.setId(UUID.randomUUID().toString());
//			client.setFirstName(faker.name().firstName());
//			client.setLastName(faker.name().lastName());
//			client.setDateOfBirth(faker.date().birthday().toString());
//			client.setDrivingLicenseNumber(faker.regexify("[A-Z0-9]{9}"));
//			clients.add(client);
//		}
//		return clients;
//	}
}

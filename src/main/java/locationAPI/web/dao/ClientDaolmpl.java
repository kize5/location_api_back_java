package locationAPI.web.dao;


import com.github.javafaker.Faker;
import locationAPI.example.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ClientDaolmpl implements ClientDao {

	public static List<Client> clients = new ArrayList<>();

	static {
		Faker faker = new Faker();
		for (int i = 0; i < 10; i++) {
			Client client = new Client();
			client.setId(UUID.randomUUID().toString());
			client.setFirstName(faker.name().firstName());
			client.setLastName(faker.name().lastName());
			client.setDateOfBirth(faker.date().birthday().toString());
			client.setDrivingLicenseNumber(faker.regexify("[A-Z0-9]{9}"));
			client.setAnimal(faker.animal().name());
//			clients.add(new Client("1", "name", "namee", "55555", "5845445"));
			clients.add(client);
		}
	}

	@Override
	public List<Client> findAll() {
		return clients;
	}

	@Override
	public Client findById(String id) {
		for (Client client : clients) {
			if (client.getId().equals(id)){
				return client;
			}
		}
		return null;
	}

	@Override
	public Client save(Client client) {
		client.setId(UUID.randomUUID().toString());
		clients.add(client);
	return client;
	}

	public Client remove(String id) {
		Client clientToRemove = null;
		for (Client client : clients) {
			if (client.getId().equals(id)) {
				clientToRemove = client;
				break;
			}
		}
		if (clientToRemove != null) {
			clients.remove(clientToRemove);
		}
		return clientToRemove;
	}

	public Client update(Client updatedClient) {
		for (Client client : clients) {
			if (client.getId().equals(updatedClient.getId())) {
				client.setFirstName(updatedClient.getFirstName());
				client.setLastName(updatedClient.getLastName());
				client.setDateOfBirth(updatedClient.getDateOfBirth());
				client.setDrivingLicenseNumber(updatedClient.getDrivingLicenseNumber());
				client.setAnimal(updatedClient.getAnimal());
				return client;
			}
		}
		return null;
	}
}

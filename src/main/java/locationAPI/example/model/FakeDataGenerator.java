package locationAPI.example.model;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeDataGenerator {

	public List<Client> FakeDataGenerator() {
		Faker faker = new Faker();
		//Génération de 10 clients factices
		List<Client> clients = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Client client = new Client();
			client.setId(UUID.randomUUID().toString());
			client.setFirstName(faker.name().firstName());
			client.setLastName(faker.name().lastName());
			client.setDateOfBirth(faker.date().birthday().toString());
			client.setDrivingLicenseNumber(faker.regexify("[A-Z0-9]{9}"));
			clients.add(client);
		}

		return clients;
//		//Affichage de la liste des clients
//		System.out.println("Liste des clients :");
//		clients.forEach(client -> System.out.println("ID : " +client.getId() + " || FirstName :  " + client.getFirstName() + " || LastName : " + client.getLastName()));
//
////		Affichage d'un client par son id
//		String clientIdToFind = clients.get(3).getId(); // On récupère l'id du client n°3
//		Optional<Client> clientById = clients.stream()
//				.filter(client -> client.getId().equals(clientIdToFind))
//				.findFirst();
//		if (clientById.isPresent()) {
//			System.out.println("Client trouvé : " + clientById.get());
//		} else {
//			System.out.println("Client non trouvé avec l'id : " + clientIdToFind);
//		}
	}
}

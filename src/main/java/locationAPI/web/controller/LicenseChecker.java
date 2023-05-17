package locationAPI.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LicenseChecker {


	// Créer une instance de RestTemplate pour effectuer la requête
	public boolean checker(String license) {

		// Construire l'URL de l'API à appeler
		String apiUrl = "http://localhost:8081/licenses/" + license;
		RestTemplate restTemplate = new RestTemplate();

		// Envoyer la requête à l'API et récupérer la réponse
		ResponseEntity<Boolean> response = restTemplate.getForEntity(apiUrl, Boolean.class);

		// Vérifier si la réponse de l'API est vraie ou fausse
		boolean isValid = Boolean.TRUE.equals(response.getBody());
//		if (isValid) {
//			System.out.println("La licence avec l'ID " + license + " est valide.");
//		} else {
//			System.out.println("La licence avec l'ID " + license + " n'est pas valide.");
//		}
		return isValid;
	}
}

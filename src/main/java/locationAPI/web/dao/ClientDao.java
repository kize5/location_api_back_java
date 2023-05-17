package locationAPI.web.dao;

import locationAPI.example.model.Client;
import locationAPI.web.ClientNotFoundException;

import java.util.List;


public interface ClientDao {
	List<Client> findAll();
	Client findById(String id);
	Client save(Client client);
	Client remove(String id);
	Client update(Client client) throws ClientNotFoundException;
}
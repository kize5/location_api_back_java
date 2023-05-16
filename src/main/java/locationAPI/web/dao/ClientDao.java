package locationAPI.web.dao;

import locationAPI.example.model.Client;

import java.util.List;


public interface ClientDao {
	List<Client> findAll();
	Client findById(String id);
	Client save(Client product);
}
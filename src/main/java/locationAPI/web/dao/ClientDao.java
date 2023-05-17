package locationAPI.web.dao;

import locationAPI.example.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface ClientDao extends JpaRepository<Client, String> {

//	@Query("SELECT id, first_name, last_name FROM client WHERE animal = :animal")
//	List<Client> findByAnimal(@Param("animal") String animal);


//	Optional<Client> findById(String id);
//	List<Client> findAll();
//	Client findById(String id);
//	Client save(Client client);
//	Client remove(String id);
//	Client update(Client client) throws ClientNotFoundException;
}
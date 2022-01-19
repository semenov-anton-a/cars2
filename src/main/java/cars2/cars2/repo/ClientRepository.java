package cars2.cars2.repo;

import cars2.cars2.models.Client;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Integer>{

    @EntityGraph(value = "Client.clientAndCars")
    List<Client> findByIdNotNull();

}
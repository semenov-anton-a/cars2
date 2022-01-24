package cars2.cars2.repo;

import cars2.cars2.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<Client, Integer>{}
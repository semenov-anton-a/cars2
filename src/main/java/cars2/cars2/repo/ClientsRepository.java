package cars2.cars2.repo;

import cars2.cars2.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientsRepository extends JpaRepository<Clients, Long>{}
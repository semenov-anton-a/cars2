package cars2.cars2.repo;

import cars2.cars2.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarsRepository extends JpaRepository<Cars, Long>{}
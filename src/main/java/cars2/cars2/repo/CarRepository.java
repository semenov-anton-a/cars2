package cars2.cars2.repo;

import cars2.cars2.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Integer> {}
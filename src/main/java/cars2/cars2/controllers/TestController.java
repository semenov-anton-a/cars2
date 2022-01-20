package cars2.cars2.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cars2.cars2.models.Car;
import cars2.cars2.models.Client;
import cars2.cars2.repo.CarRepository;
import cars2.cars2.repo.ClientRepository;

@Controller
public class TestController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/tests")
    public String getTests() {
        return "/tests/index";
    }

    @GetMapping("/tests/addcar")
    public String addCar() {
        String vin = "vin1234";
        String reg = "qwe-123";
        String brand = "lada";
        String model = "model";
        String year = "1980";

        Car car = new Car(vin, brand, model, reg, year, new ArrayList<>());

        carRepository.save(car);

        return "/tests/addcar";
    }

    @GetMapping("/tests/addclient")
    public String addClient() {
        String name = "Anton";
        String surname = "Semenov";

        Client client = new Client(name, surname, new ArrayList<>());

        clientRepository.save(client);

        return "/tests/addclient";
    }

    @GetMapping("/tests/showrel")
    public String showRelations() {
        return "/tests/showrel";
    }

    @Transactional
    @GetMapping("/tests/makerel")
    public String makeRelations() {
        /**
         * WORK
         */
        // Car car1 = carRepository.getById(3);
        // Client cl = clientRepository.getById(2);

        /**
         * @EXAMPLE 1
         *          CARs TO Clients
         */
        // car1.getClientCars().add(cl);
        // carRepository.save(car1);

        /**
         * @EXAMPLE 2
         *          CARs TO Clients
         */
        // cl.getCarClients().add(car1);
        // clientRepository.save(cl);

        /**
         * @EXAMPLE 3
         * Get Collections
         */
        // int iDs = 1;

        // List<Integer> ids = Arrays.asList(1,2);
        
        // Iterable<Car> cars = carRepository.findAllById( ids );
        // OR
        // Object cars = carRepository.findAllById(iDs);
        
        // System.out.println(cars);
        
        return "redirect:/tests/showrel";
    }

}

package cars2.cars2.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    
    @GetMapping("/tests/getclientcar")
    public String getclientcar( Model model ) {
        
        // clientRepository.getById(5).getClientCars();

        
        // clientRepository.mySort(  clientRepository.getById(5).getClientCars()  );


        // clientRepository.getById(5).getClientCars().get(0);
        System.out.println(  );
        

        /** ================ */
        // Object[] list =  clientRepository.getById(5).getClientCars().toArray();
        // System.out.println( list );
        /** ================ */

        // ArrayList list = new ArrayList<>();

        System.out.println( "HELLo" );

        // model.addAttribute("clients", clientRepository.findAll() );
        
        // Client client = clientRepository.getById(5);
        
        // client.getClientCars();     
        // List<Car> cr = clientRepository.findByCarId(2);     
        
        // System.out.println( client );


        // WORK IN DATA BASE
        // Client client = clientRepository.getById(5);
        // System.out.println( client.getClientCars() );
        
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

        Car Ford = new Car( "vin1234", "Ford", "Mondeo", "FRD-000", "2011", new ArrayList<>());
        Car Bmw = new Car( "vin6678", "BMW", "X5", "BMW-123", "2021", new ArrayList<>());
        Car Lada = new Car( "vin6678", "Lada", "Calina", "SPB-78", "1986", new ArrayList<>());
        Car Audi = new Car( "vin6678", "Audi", "TT", "ADI-100", "1992", new ArrayList<>());

        carRepository.save(Ford);
        carRepository.save(Bmw);
        carRepository.save(Lada);
        carRepository.save(Audi);

        Client Anton = new Client( "Anton", "Semenov", new ArrayList<>() );
        Client Ivan = new Client( "Ivan", "Petrov", new ArrayList<>() );
        
        clientRepository.save( Anton );
        clientRepository.save( Ivan );

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
        
        return "redirect:/tests/makerel";
    }

}

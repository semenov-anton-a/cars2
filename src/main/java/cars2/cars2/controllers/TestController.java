package cars2.cars2.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public String getTests()
    {
        return "/tests/index";
    }

    @GetMapping("/tests/addcar")
    public String addCar()
    {
        String vin = "vin1234";
        String reg = "qwe-123";
        String brand = "lada";
        String model = "model";
        String year = "1980";

        Car car = new Car( vin, brand, model, reg, year, new ArrayList<>() );
        
        carRepository.save( car );

        return "/tests/addcar";
    }

    @GetMapping("/tests/addclient")
    public String addClient()
    {
        String name = "Anton";
        String surname = "Semenov";

        Client client = new Client( name, surname, new ArrayList<>() );

        clientRepository.save( client );

        return "/tests/addclient";
    }
    
    @GetMapping("/tests/showrel")
    public String showRelations()
    {
        return "/tests/showrel";
    }
    
    @Transactional
    @GetMapping("/tests/makerel")
    public String makeRelations()
    {

        // System.out.println("=>>>>>>>>   CAR");
        // System.out.println( carRepository.getById(  1  ) );

        // System.out.println("=>>>>>>>>   CLIENT");
        // System.out.println( clientRepository.getById(  2  ) );

        // clientRepository.getById( 2 ).getCars().add(carRepository.getById( 1) ) ;
        // clientRepository.getOne( 3 ).getCars().add(  carRepository.getOne( 1) ) ;
        
        
        System.out.println( clientRepository.getById( 3 ) );
        
        Car cars = carRepository.getOne(2);
        System.out.println(cars);

        clientRepository.getOne( 3 ).getCars().add( 0, cars );

        // clientRepository.getById( 3 ).setCars( cars ) ;
        // clientRepository.getById( 3 ).getCars().setCars(carRepository.getById( 2 ));
        
        



        System.out.println( );

        // clientRepository.getById( (long) 2 ).getCars().set( 1, carRepository.getById((long) 1) );



        return "redirect:/tests/showrel";
    }


}

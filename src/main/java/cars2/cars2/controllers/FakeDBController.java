package cars2.cars2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cars2.cars2.models.Car;
import cars2.cars2.models.Client;
import cars2.cars2.repo.CarRepository;
import cars2.cars2.repo.ClientRepository;
@Controller
public class FakeDBController {
    
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping("/fakedb")
    public String getIndex()
    {
        this.makeCars();
        this.makeClients();
        return "redirect:/";
    }



    private void makeCars(){
        
        List<Car> cars = new ArrayList<Car>();
        
        cars.add( new Car( "vin1234", "BMW", "X5", "ZXC-123", "2015", null ) );
        cars.add( new Car( "vin5555", "Audi", "100", "GHJ-888", "2010", null ) );
        cars.add( new Car( "vin7899", "VW", "Golf", "PGH-679", "2000", null ));
        cars.add( new Car( "vin4567", "Lada", "Calina", "VGH-456", "2014", null ));
        cars.add( new Car( "vin0956", "Mersedes", "S Class", "HJK-345", "2021", null ));
        cars.add( new Car( "vin8576", "Volvo", "S 80", "XCV-654", "2004", null ));
        cars.add( new Car( "vin2336", "Saab", "9000", "DRT-468", "1999", null ));
        cars.add( new Car( "vin8542", "Ford", "Modeo", "FZD-990", "2002", null ));
        cars.add( new Car( "vin4568", "Toyota", "Lang Cruser", "TRY-334", "2005", null ));
        cars.add( new Car( "vin3654", "Mazda", "RX 7", "MRX-777", "2005", null ));

        carRepository.saveAll(cars);
    }

    private void makeClients(){
        List<Client> clients = new ArrayList<Client>();
    
        clients.add( new Client( "Anton", "Semenov", null ) );
        clients.add( new Client( "Vladimir", "Putin", null ) );
        clients.add( new Client( "Pekka", "Halikainen", null ) );
        clients.add( new Client( "Matti", "Vuorola", null ) );
        clients.add( new Client( "Jussi", "Pakilainen", null ) );
        clients.add( new Client( "Helena", "Antonen", null ) );
        clients.add( new Client( "Tarja", "Halonen", null ) );
        clients.add( new Client( "Joe", "Biden", null ) );
        clients.add( new Client( "Donald", "Trump", null ) );
        clients.add( new Client( "Adolf", "Hitler", null ) );
        clients.add( new Client( "Josif", "Stalin", null ) );
        
        clientRepository.saveAll( clients );
    }

}

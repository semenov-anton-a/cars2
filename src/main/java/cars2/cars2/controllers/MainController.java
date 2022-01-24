package cars2.cars2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cars2.cars2.models.Car;
import cars2.cars2.models.Client;
import cars2.cars2.repo.CarRepository;
import cars2.cars2.repo.ClientRepository;

@Controller
public class MainController 
{
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/")
    public String getIndex( Model model )
    {
        // HTML Title
        model.addAttribute("title", "AutoRegistration");
        model.addAttribute("selectClients", clientRepository.findAll() );
        model.addAttribute("selectCars", carRepository.findAll() );
        return "index";
    }

    @PostMapping( path = "/findcars")
    public String getCarsByOwner(Model model, @RequestParam int clientid )
    {
        if( clientid == 0 ){
            return this.getIndex( model );
        }

        Client client = clientRepository.getById(clientid);
        model.addAttribute("clientName", client );
        model.addAttribute( "carsListByClient", client.getClientCars() );  
        
        return this.getIndex( model );
    }

    @PostMapping( path = "/findclients")
    public String getClientsByCars(Model model, @RequestParam int carid )
    {
        if( carid == 0 ){
            return this.getIndex( model );
        }
        Car car = carRepository.getById(carid);

        System.out.println( car.getReg() );

        model.addAttribute( "carData", car );
        model.addAttribute( "clients", car.getCarClients() );
        return this.getIndex( model );
    }






    @GetMapping("/showallcars")
    public String getShowAllCars(Model model){

        List<Car> carList = carRepository.findAll();
        model.addAttribute( "carDataList", carList );

        return this.getIndex( model );
    }

}

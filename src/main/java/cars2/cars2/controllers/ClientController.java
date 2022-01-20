package cars2.cars2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
public class ClientController 
{
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private CarRepository carRepository;


    @GetMapping("/addclient")
    public String getIndex( Model model )
    {
        model.addAttribute("title", "Add Client");
        model.addAttribute("clients", clientRepository.findAll() );
        
        model.addAttribute("cars", carRepository.findAll() );
        System.out.println("HELLo");
        return "addclient";
    }

    @PostMapping(
        path = "/addclient",
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } ) 
    public String addClient( Client data ) 
    {
        clientRepository.save( data );
        return "redirect:/addclient";
    }

    @PostMapping( path = "/addclient/relations" )
    public String makeRelations( 
        @RequestParam Long clientid,
        @RequestParam (value = "carids[]") List<Integer> carids ) 
    {
        System.out.println("======RUN========");
        
        // ArrayList<Car> cars = (ArrayList<Car>) carRepository.findAllById( carids );
        // System.out.println( cars.get(0) );
        
        // Iterable<Car> cars = carRepository.findAllById( carids );
        




        System.out.println("===============");
        // System.out.println( clientid );
        // System.out.println( carids );
        return "redirect:/addclient";
    }
}

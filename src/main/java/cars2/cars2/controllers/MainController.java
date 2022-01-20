package cars2.cars2.controllers;

import java.util.ArrayList;
import java.util.Collection;
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

    // private List<Car> carList;
    // private 

    @GetMapping("/")
    public String getIndex( Model model )
    {
        model.addAttribute("title", "AutoRegistration");

        // model.addAttribute("clients", clientRepository.findAll() );

        // model.addAttribute("clID", this.carsList);

        System.out.println("HELLo");
        return "index";
    }

    // private List<Car> carsList;

    @PostMapping( path = "/findcars")
    public String getCarsByOwner( @RequestParam int clientid )
    {
        // Client cl = clientRepository.getById( clientid );
        // Car cars = carRepository.

        // this.carsList = clientid;
        // System.out.println( cl );

        return "redirect:/";
    }

}

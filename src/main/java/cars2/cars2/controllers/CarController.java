package cars2.cars2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cars2.cars2.models.Car;
import cars2.cars2.repo.CarRepository;
import cars2.cars2.repo.ClientRepository;

@Controller
public class CarController 
{
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/addcar")
    public String getIndex( Model model )
    {
        model.addAttribute("title", "Add Car");
        System.out.println("HELLo");
        return "addcar";
    }


    @PostMapping(
        path = "/addcar",
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } ) 
    public String addCar( Car data ) 
    {   
        carRepository.save( data );
        return "redirect:/addcar";
    }


    

}

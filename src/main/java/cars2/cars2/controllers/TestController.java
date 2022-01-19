package cars2.cars2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cars2.cars2.repo.CarsRepository;
import cars2.cars2.repo.ClientsRepository;

@Controller
public class TestController {
    
    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private CarsRepository carsRepository;



    @GetMapping("/tests")
    public String getTests()
    {
        return "/tests/index";
    }



    @GetMapping("/tests/addcar")
    public String addCar()
    {
        return "/tests/addcar";
    }

    @GetMapping("/tests/addclient")
    public String addClient()
    {
        return "/tests/addclient";
    }
    
    @GetMapping("/tests/showrel")
    public String showRelations()
    {
        return "/tests/showrel";
    }
    
    @GetMapping("/tests/makerel")
    public String makeRelations()
    {
        return "redirect:/tests/showrel";
    }


}

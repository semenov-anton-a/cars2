package cars2.cars2.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cars2.cars2.models.Car;

@Controller
public class CarController 
{
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
        // System.out.println( data.getReg() );
        // System.out.println(data);
        return "redirect:/addcar";
    }

}

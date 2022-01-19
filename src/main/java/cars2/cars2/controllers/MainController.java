package cars2.cars2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    
    @GetMapping("/")
    public String getIndex()
    {
        System.out.println("HELLo");
        return "index";
    } 


}

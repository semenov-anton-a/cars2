package cars2.cars2.controllers;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cars2.cars2.ErrorMsg;
import cars2.cars2.models.Car;
import cars2.cars2.models.Client;
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
        model.addAttribute("clients", clientRepository.findAll() );
        model.addAttribute("carData", carRepository.findAll() );
        return "addcar";
    }


    @PostMapping(
        path = "/addcar",
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } ) 
    public String addCar( Car data ) 
    {   
        if( data.isEmpty() ){
            return "redirect:/addcar";
        }
        
        carRepository.save( data );
        return "redirect:/addcar";
    }


    @Transactional
    @PostMapping( path = "/addcars/relations" )
    public String makeRelations( 
        @RequestParam int carid,
        @RequestParam (value = "clients[]",  defaultValue="-1") List<Integer> clients ) 
    {   // BEGIN METHOD

        if( carid == 0 | clients.get(0) == -1) { 
            new ErrorMsg().msgError( "Request Params not match." );
            return "redirect:/addcar"; 
        }

        Car carData = carRepository.getById( carid ); 
        Collection<Client> clientsData = clientRepository.findAllById( clients );
        carData.getCarClients().addAll( clientsData );
        return "redirect:/addcar";
    }
    

}

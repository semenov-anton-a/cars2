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
        return "addclient";
    }

    @PostMapping(
        path = "/addclient",
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } ) 
    public String addClient( Client data ) 
    {
        if( data.isEmpty() ){
            return "redirect:/addclient";
        }

        clientRepository.save( data );
        return "redirect:/addclient";
    }

    @Transactional
    @PostMapping( path = "/addclient/relations" )
    public String makeRelations( 
        @RequestParam int clientid,
        @RequestParam (value = "carids[]",  defaultValue="-1") List<Integer> carids ) 
    {

        if( clientid == 0 | carids.get(0) == -1) { 
            new ErrorMsg().msgError( "Request Params not match." );
            return "redirect:/addclient"; 
        }

        Client client = clientRepository.getById( clientid );
        Collection<Car> cars = carRepository.findAllById( carids );
        
        client.getClientCars().addAll(cars);
        // carRepository.saveAll(cars);
     
        return "redirect:/addclient";
    }

    
}

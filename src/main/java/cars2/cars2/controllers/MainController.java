package cars2.cars2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    private Integer countOfPage = 4;
   

    private MainController showPaginations( Model model, boolean pagination, String url ){
        model.addAttribute("pagination", pagination );
        model.addAttribute("paginationUri", url );
        return this;
    }

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
    @GetMapping( path = "/findcars/{carid}")
    public String getCarsByOwnerOd(Model model, @PathVariable int carid )
    {
        return this.getCarsByOwner(model, carid);
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

    @GetMapping( path = "/findclients/{carid}")
    public String getClientsByCarsId(Model model, @PathVariable int carid )
    {
        return this.getClientsByCars(model, carid);
    }



    @GetMapping("/showallcars")
    public String getShowAllCars(Model model, @RequestParam(defaultValue = "0") Integer page){
        
        Pageable pageable = PageRequest.of(page, this.countOfPage );
        Page<Car> pageTable = carRepository.findAll( pageable );
        
        model.addAttribute( "carDataList", pageTable  );

        int pageB = 0;
        pageB = ( pageTable.hasPrevious() ) ? page - 1 : -1 ;
        
        int pageN = 0;
        pageN = ( pageTable.hasNext() ) ? page + 1: -1;

        model.addAttribute( "pageBack", pageB );
        model.addAttribute( "pageNext", pageN );

        return this.showPaginations(model, true, "/showallcars").getIndex( model );
    }

    @GetMapping("/showallclients")
    public String getShowAllClients(Model model, @RequestParam(defaultValue = "0") Integer page){
        
        Pageable pageable = PageRequest.of(page, this.countOfPage );
        Page<Client> pageTable = clientRepository.findAll( pageable );
        
        model.addAttribute( "clientDataList", pageTable  );
        
        int pageB = 0;
        pageB = ( pageTable.hasPrevious() ) ? page - 1 : -1 ;
        
        int pageN = 0;
        pageN = ( pageTable.hasNext() ) ? page + 1: -1;

        model.addAttribute( "pageBack", pageB );
        model.addAttribute( "pageNext", pageN );

        return this.showPaginations(model, true, "/showallclients").getIndex( model );
    }

}

package cars2.cars2.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cars2.cars2.models.Client;

@Controller
public class ClientController 
{
    @GetMapping("/addclient")
    public String getIndex( Model model )
    {
        model.addAttribute("title", "Add Client");
        System.out.println("HELLo");
        return "addclient";
    }

    @PostMapping(
        path = "/addclient",
        consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } ) 
    public String addClient( Client data ) 
    {
        System.out.println( data );
        // System.out.println(data);
        return "redirect:/addclient";
    }

    // TODO::Relations
    // @PostMapping(
    //     path = "/addclient/relations",
    //     consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE } ) 
    // public String makeRelations( List<String> data ) 
    // {
    //     System.out.println( data );
    //     // System.out.println(data);
    //     return "redirect:/addclient";
    // }
}

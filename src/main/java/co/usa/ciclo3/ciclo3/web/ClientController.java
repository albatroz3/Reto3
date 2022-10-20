package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.Service.ClientService;
import co.usa.ciclo3.ciclo3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/All*")
    public List<Client> getClients(){
        return clientService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }
}

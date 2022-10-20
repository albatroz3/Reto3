package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.Service.MessageService;
import co.usa.ciclo3.ciclo3.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class MessageController {

    @Autowired
    private MessageService messageService;
    @GetMapping("/All*")
    public Optional<Message> getMessage(@PathVariable("id")int id){
        return messageService.getMessage(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return messageService.save(message);
    }
}

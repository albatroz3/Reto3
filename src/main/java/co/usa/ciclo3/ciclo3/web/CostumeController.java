package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.Service.CostumeService;
import co.usa.ciclo3.ciclo3.model.Costume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Costume")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class CostumeController<costume> {
    @Autowired
    private CostumeService costumeService;

    @GetMapping("/All")
    public List<Costume> getCostumes(){
        return costumeService.getAll();
    }
    @GetMapping("{id}")
    public Optional<Costume> getCostume(@PathVariable("id")int id){
        return costumeService.getCostume(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume costume){
        return costumeService.save(costume);
    }
}

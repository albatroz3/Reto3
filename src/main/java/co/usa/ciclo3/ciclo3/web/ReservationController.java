package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.Service.ReservationService;
import co.usa.ciclo3.ciclo3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ReservationController<reservation> {

    @Autowired
    private ReservationService reservationService;
    private Reservation reservation;


    @GetMapping("/All*")
    public List<Reservation> getReservation() {
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(RequestBody Reservation){
       return reservationService.save(reservation);
    }
}

package co.usa.ciclo3.ciclo3.Repository;

import co.usa.ciclo3.ciclo3.Repository.crud.CostumeCrudRepository;
import co.usa.ciclo3.ciclo3.Repository.crud.ReservationCrudRepository;
import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.model.Costume;
import co.usa.ciclo3.ciclo3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation) {
       reservationCrudRepository.delete(reservation);
    }
}

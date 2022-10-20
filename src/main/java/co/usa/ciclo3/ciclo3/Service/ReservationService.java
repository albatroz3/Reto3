package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Repository.CategoryRepository;
import co.usa.ciclo3.ciclo3.Repository.ReservationRepository;
import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.CompositeData;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) { return reservationRepository.getReservation(id); }

    public Reservation save(Reservation reservation) {
        if (reservation.getId() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> aux = reservationRepository.getReservation((Integer) reservation.getId());
            if (aux.isPresent()) {
                return reservation;
            } else {
                return reservationRepository.save(reservation);
            }
        }
    }
    public Reservation update(Reservation reservation) {
        if (reservation.getId() != null) {
            Optional<Reservation> c = reservationRepository.getReservation((Integer) reservation.getId());
            if (c.isPresent()) {
                if (reservation.getStartDate() != null) {
                    c.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    c.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getCostume() != null) {
                    c.get().setCostume(reservation.getCostume());
                }
                if (reservation.getClient() != null) {
                    c.get().setClient(reservation.getClient());
                }
                if (reservation.getScore() != null) {
                    c.get().setScore(reservation.getScore());
                }
                reservationRepository.save(c.get());
                return c.get();
            } else {
                return reservation;
            }
        } else{
            return reservation;
        }
    }
            public boolean delete(int id){
         boolean flag = false;
         Optional<Reservation> a = reservationRepository.getReservation(id);
         if (a.isPresent()) {
                 reservationRepository.delete(a.get());
         }
         return flag;
    }
}










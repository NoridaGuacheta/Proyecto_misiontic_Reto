package com.misiontic.usergioarboleda.Ortesis.repositories;

import java.util.List;
import java.util.Optional;
import com.misiontic.usergioarboleda.Ortesis.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;


    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCRUDRepository.findAll();
    }


    public Optional<Reservation> getReservation(int id){
        return reservationCRUDRepository.findById(id);
    }


    public Reservation save(Reservation reservation){
        return reservationCRUDRepository.save(reservation);
    }


    public void delete(Reservation reservation){
        reservationCRUDRepository.delete(reservation);
    }
}

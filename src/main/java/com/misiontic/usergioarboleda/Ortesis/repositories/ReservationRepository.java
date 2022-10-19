package com.misiontic.usergioarboleda.Ortesis.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.misiontic.usergioarboleda.Ortesis.models.Client;
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
    
    // ============ Informe ============ //
    
    public List<Reservation> getReservationByStatus (String status){
        return reservationCRUDRepository.findAllByStatus(status);
    }
    
    public List<Reservation> informePeriodoTiempoReservas (Date a, Date b){
        return reservationCRUDRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    
    public List<CountClient> getTopClient(){
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservationCRUDRepository.countTotalReservationByClient();
        for(int i=0;i < report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1], (Client) report.get(i)[0]));
        }
        return res;
    }
        
}

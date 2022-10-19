package com.misiontic.usergioarboleda.Ortesis.repositories;

import com.misiontic.usergioarboleda.Ortesis.models.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCRUDRepository extends CrudRepository<Reservation, Integer> {
  
   public List<Reservation> findAllByStatus(String status);
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date datoUno, Date datodos);
    
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();
}

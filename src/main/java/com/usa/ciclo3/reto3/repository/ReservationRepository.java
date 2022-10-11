package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.CRUD.ReservationCrudRepositoryInterfaz;

@Repository
public class ReservationRepository {
    @Autowired
    public ReservationCrudRepositoryInterfaz reservationCrudRepositoryInterfaz;

    public List<Reservation> obtenerReservation() {
        return (List<Reservation>) reservationCrudRepositoryInterfaz.findAll();
    }

    public Reservation salvarReservation(Reservation reservation) {
        return reservationCrudRepositoryInterfaz.save(reservation);
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepositoryInterfaz.findById(id);
    }

    public void delete(Reservation reservation) {
        reservationCrudRepositoryInterfaz.delete(reservation);
    }

}

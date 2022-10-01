package com.usa.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> obtenerReservation() {
        return reservationRepository.obtenerReservation();
    }

    public Reservation salvarReservation(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.salvarReservation(reservation);
        } else {
            return reservation;
        }
    }

}

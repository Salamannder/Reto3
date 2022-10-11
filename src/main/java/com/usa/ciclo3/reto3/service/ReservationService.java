package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

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

    public Reservation actualizaReservation(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                if (reservation.getPartyroom() != null) {
                    e.get().setPartyroom(reservation.getPartyroom());
                }
                if (reservation.getClient() != null) {
                    e.get().setClient(reservation.getClient());
                }
                if (reservation.getScore() != null) {
                    e.get().getScore(reservation.getScore());
                }
                reservationRepository.salvarReservation(e.get());
                return e.get();

            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean borrarReservation(int reservationId) {
        boolean flag = false;
        Optional<Reservation> c = reservationRepository.getReservation(reservationId);
        if (c.isPresent()) {
            reservationRepository.delete(c.get());
            flag = true;
        }
        return flag;

    }

}

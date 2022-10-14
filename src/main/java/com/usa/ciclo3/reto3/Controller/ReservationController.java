package com.usa.ciclo3.reto3.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.reportes.ContadorClientes;
import com.usa.ciclo3.reto3.reportes.StatusReservas;
import com.usa.ciclo3.reto3.service.ReservationService;



@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

public class ReservationController {
    @Autowired
    public ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> obtenerReservation() {
        return reservationService.obtenerReservation();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation salvarReservation(@RequestBody Reservation Reservation) {
        return reservationService.salvarReservation(Reservation);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation actualizaReservation(@RequestBody Reservation reservation) {
        return reservationService.actualizaReservation(reservation);
    }

    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarReservation(@PathVariable("idReservation") int reservationId) {
        return reservationService.borrarReservation(reservationId);

    }

     
    @GetMapping("/report-status")
    public StatusReservas getStatusReservas() {
        return reservationService.ReservacionStatus();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo(@PathVariable("dateOne") String fechaInicial,@PathVariable("dateTwo") String fechaFinal) {
        return reservationService.ReservacionTiempo(fechaInicial, fechaFinal);
    }

    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes() {
        return reservationService.reporteClientes();
    }
    
}

package com.usa.ciclo3.reto3.Controller;

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

import com.usa.ciclo3.reto3.model.Partyroom;
import com.usa.ciclo3.reto3.service.PartyroomService;

@RestController
@RequestMapping("/api/Partyroom")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class PartyroomController {
    @Autowired
    public PartyroomService partyroomService;

    @GetMapping("/all")
    public List<Partyroom> obtenerPartyroom() {
        return partyroomService.obtenerPartyroom();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom salvarPartyroom(@RequestBody Partyroom Partyroom) {
        return partyroomService.salvarPartyroom(Partyroom);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom actualizapPartyroom(@RequestBody Partyroom partyroom) {
        return partyroomService.actualizaPartyroom(partyroom);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarPartyroom(@PathVariable("id") int partyroomId) {
        return partyroomService.borrarPartyroom(partyroomId);

    }
}

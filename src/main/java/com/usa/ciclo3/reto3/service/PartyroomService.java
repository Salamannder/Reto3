package com.usa.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.Partyroom;
import com.usa.ciclo3.reto3.repository.PartyroomRepository;

@Service
public class PartyroomService {
    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> obtenerPartyroom() {
        return partyroomRepository.obtenerPartyroom();
    }

    public Partyroom salvarPartyroom(Partyroom partyroom) {
        if (partyroom.getId() == null) {
            return partyroomRepository.salvarPartyroom(partyroom);
        } else {
            return partyroom;
        }
    }

}

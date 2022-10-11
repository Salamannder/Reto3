package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

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

    public Partyroom actualizaPartyroom(Partyroom partyroom) {
        if (partyroom.getId() != null) {
            Optional<Partyroom> e = partyroomRepository.getPartyroom(partyroom.getId());
            if (!e.isEmpty()) {
                if (partyroom.getName() != null) {
                    e.get().setName(partyroom.getName());
                }
                if (partyroom.getOwner() != null) {
                    e.get().setOwner(partyroom.getOwner());
                }
                if (partyroom.getCapacity() != null) {
                    e.get().setCapacity(partyroom.getCapacity());
                }
                if (partyroom.getDescription() != null) {
                    e.get().setDescription(partyroom.getDescription());
                }
                if (partyroom.getCategory() != null) {
                    e.get().setCategory(partyroom.getCategory());
                }
                partyroomRepository.salvarPartyroom(e.get());
                return e.get();

            } else {
                return partyroom;
            }
        } else {
            return partyroom;
        }
    }

    public boolean borrarPartyroom(int partyroomId) {
        boolean flag = false;
        Optional<Partyroom> c = partyroomRepository.getPartyroom(partyroomId);
        if (c.isPresent()) {
            partyroomRepository.delete(c.get());
            flag = true;
        }
        return flag;

    }

}

package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Partyroom;
import com.usa.ciclo3.reto3.repository.CRUD.PartyroomCrudRepositoryInterfaz;

@Repository
public class PartyroomRepository {
    @Autowired
    public PartyroomCrudRepositoryInterfaz partyroomCrudRepositoryInterfaz;

    public List<Partyroom> obtenerPartyroom() {
        return (List<Partyroom>) partyroomCrudRepositoryInterfaz.findAll();
    }

    public Partyroom salvarPartyroom(Partyroom partyroom) {
        return partyroomCrudRepositoryInterfaz.save(partyroom);
    }

    public Optional<Partyroom> getPartyroom(int id) {
        return partyroomCrudRepositoryInterfaz.findById(id);
    }

    public void delete(Partyroom partyroom) {
        partyroomCrudRepositoryInterfaz.delete(partyroom);
    }

}

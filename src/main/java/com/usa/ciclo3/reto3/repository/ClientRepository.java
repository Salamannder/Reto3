package com.usa.ciclo3.reto3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.repository.CRUD.ClientCrudRepositoryInterfaz;

@Repository
public class ClientRepository {
    @Autowired
    public ClientCrudRepositoryInterfaz clientCrudRepositoryInterfaz;

    public List<Client> obtenerClient() {
        return (List<Client>) clientCrudRepositoryInterfaz.findAll();
    }

    public Client salvarClient(Client client) {
        return clientCrudRepositoryInterfaz.save(client);
    }

}

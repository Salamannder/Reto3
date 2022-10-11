package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> obtenerClient() {
        return clientRepository.obtenerClient();
    }

    public Client salvarClient(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.salvarClient(client);
        } else {
            return client;
        }
    }

    public Client actualizaClient(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getEmail() != null) {
                    e.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                clientRepository.salvarClient(e.get());
                return e.get();

            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean borrarClient(int clientId) {
        boolean flag = false;
        Optional<Client> c = clientRepository.getClient(clientId);
        if (c.isPresent()) {
            clientRepository.delete(c.get());
            flag = true;
        }
        return flag;

    }

}

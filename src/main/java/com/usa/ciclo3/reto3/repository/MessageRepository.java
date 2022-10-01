package com.usa.ciclo3.reto3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.repository.CRUD.MessageCrudRepositoryInterfaz;

@Repository
public class MessageRepository {
    @Autowired
    public MessageCrudRepositoryInterfaz messageCrudRepositoryInterfaz;

    public List<Message> obtenerMessage() {
        return (List<Message>) messageCrudRepositoryInterfaz.findAll();
    }

    public Message salvarMessage(Message message) {
        return messageCrudRepositoryInterfaz.save(message);
    }

}

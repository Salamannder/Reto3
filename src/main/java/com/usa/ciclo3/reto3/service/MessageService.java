package com.usa.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> obtenerMessage() {
        return messageRepository.obtenerMessage();
    }

    public Message salvarMessage(Message message) {
        if (message.getId() == null) {
            return messageRepository.salvarMessage(message);
        } else {
            return message;
        }
    }

}

package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

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
        if (message.getIdMessage() == null) {
            return messageRepository.salvarMessage(message);
        } else {
            return message;
        }
    }

    public Message actualizaMessage(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getmessageText() != null) {
                    e.get().setmessageText(message.getmessageText());
                }
                if (message.getPartyroom() != null) {
                    e.get().setPartyroom(message.getPartyroom());
                }
                if (message.getClient() != null) {
                    e.get().setClient(message.getClient());
                }
                messageRepository.salvarMessage(e.get());
                return e.get();

            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean borrarMessage(int messageId) {
        boolean flag = false;
        Optional<Message> c = messageRepository.getMessage(messageId);
        if (c.isPresent()) {
            messageRepository.delete(c.get());
            flag = true;
        }
        return flag;

    }

}

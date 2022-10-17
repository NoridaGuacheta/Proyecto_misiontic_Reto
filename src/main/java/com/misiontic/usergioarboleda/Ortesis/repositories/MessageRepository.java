package com.misiontic.usergioarboleda.Ortesis.repositories;

import java.util.List;
import java.util.Optional;
import com.misiontic.usergioarboleda.Ortesis.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class MessageRepository {
    @Autowired
    private MessageCRUDRepository messageCRUDRepository;


    public List<Message> getAll(){
        return (List<Message>) messageCRUDRepository.findAll();
    }


    public Optional<Message> getMessage(int id){
        return messageCRUDRepository.findById(id);
    }


    public Message save(Message message){
        return messageCRUDRepository.save(message);
    }


    public void delete(Message message){
        messageCRUDRepository.delete(message);
    }
}

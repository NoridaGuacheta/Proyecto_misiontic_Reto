package com.misiontic.usergioarboleda.Ortesis.repositories;

import java.util.List;
import java.util.Optional;
import com.misiontic.usergioarboleda.Ortesis.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ClientRepository {
    @Autowired
    private ClientCRUDRepository clientCRUDRepository;


    public List<Client> getAll(){
        return (List<Client>) clientCRUDRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCRUDRepository.findById(id);
    }


    public Client save(Client client){
        return clientCRUDRepository.save(client);
    }


    public void delete(Client client){
        clientCRUDRepository.delete(client);
    }
}



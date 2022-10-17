package com.misiontic.usergioarboleda.Ortesis.repositories;

import com.misiontic.usergioarboleda.Ortesis.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCRUDRepository extends CrudRepository<Message, Integer> {
}

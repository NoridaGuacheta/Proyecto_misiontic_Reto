package com.misiontic.usergioarboleda.Ortesis.repositories;

import java.util.List;
import java.util.Optional;
import com.misiontic.usergioarboleda.Ortesis.models.Ortopedic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class OrtopedicRepository {
    @Autowired
    private OrtopedicCRUDRepository ortopedicCRUDRepository;


    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) ortopedicCRUDRepository.findAll();
    }


    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicCRUDRepository.findById(id);
    }


    public Ortopedic save(Ortopedic ortopedic){ return ortopedicCRUDRepository.save(ortopedic); }


    public void delete(Ortopedic ortopedic){
        ortopedicCRUDRepository.delete(ortopedic);
    }


}

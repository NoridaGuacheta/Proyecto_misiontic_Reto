package com.misiontic.usergioarboleda.Ortesis.services;

import java.util.List;
import java.util.Optional;
import com.misiontic.usergioarboleda.Ortesis.models.Ortopedic;
import com.misiontic.usergioarboleda.Ortesis.repositories.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrtopedicService {

    @Autowired
    private OrtopedicRepository ortopedicRepository;

    public List<Ortopedic> getAll(){
        return ortopedicRepository.getAll();
    }

    public Optional<Ortopedic> getOrtopedic(int ortopedicId) {
        return ortopedicRepository.getOrtopedic(ortopedicId);
    }

    public Ortopedic save(Ortopedic ortopedic){
        if(ortopedic.getId()==null){
            return ortopedicRepository.save(ortopedic);
        }else{
            Optional<Ortopedic>e= ortopedicRepository.getOrtopedic(ortopedic.getId());
            if(e.isEmpty()){
                return ortopedicRepository.save(ortopedic);
            }else{
                return ortopedic;
            }
        }
    }

    public Ortopedic update(Ortopedic ortopedic){
        if(ortopedic.getId()!=null){
            Optional<Ortopedic> e= ortopedicRepository.getOrtopedic(ortopedic.getId());
            if(!e.isEmpty()){
                if(ortopedic.getName()!=null){
                    e.get().setName(ortopedic.getName());
                }
                if(ortopedic.getBrand()!=null){
                    e.get().setBrand(ortopedic.getBrand());
                }
                if(ortopedic.getYear()!=null){
                    e.get().setYear(ortopedic.getYear());
                }
                if(ortopedic.getDescription()!=null){
                    e.get().setDescription(ortopedic.getDescription());
                }
                if(ortopedic.getCategory()!=null){
                    e.get().setCategory(ortopedic.getCategory());
                }
                ortopedicRepository.save(e.get());
                return e.get();
            }else{
                return ortopedic;
            }
        }else{
            return ortopedic;
        }
    }


    public boolean deleteOrtopedic (int id){
        Boolean d = getOrtopedic(id).map(ortopedic -> {
            ortopedicRepository.delete(ortopedic);
            return true;
        }).orElse(false);
        return d;
    }


}

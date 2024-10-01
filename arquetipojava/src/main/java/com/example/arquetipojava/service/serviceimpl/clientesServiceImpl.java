package com.example.arquetipojava.service.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.arquetipojava.common.CommonSvcImpl;
import com.example.arquetipojava.models.clientesModel;
import com.example.arquetipojava.repository.clienteRepository;
import com.example.arquetipojava.service.clientesService;

@Service
public class clientesServiceImpl extends CommonSvcImpl<clientesModel, clienteRepository> implements clientesService{

    @Override
    public void deleteById(int id) {
   /* if(id == 5){
        throw new RuntimeException("No se puede eliminar el cliente con id")
    }else{
        this.repository.deleteById(id);
    }*/
    this.repository.deleteById(id);
    }

    @Override
    public Iterable<clientesModel> findAll() {
      return this.repository.findAll();
    }

    @Override
    public Optional<clientesModel> findById(int id) {
       return this.repository.findById(id);
    }

    @Override
    public clientesModel save(clientesModel entity) {
     return this.repository.save(entity);
    }

    @Override
    public Iterable<clientesModel> saveAll(Iterable<clientesModel> entities) {
    return this.repository.saveAll(entities);
    }
    
}

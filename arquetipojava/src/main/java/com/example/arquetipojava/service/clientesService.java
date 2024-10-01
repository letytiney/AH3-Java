package com.example.arquetipojava.service;

import java.util.Optional;
import com.example.arquetipojava.common.CommonSvc;
import com.example.arquetipojava.models.clientesModel;

public interface clientesService extends CommonSvc<clientesModel> {
    public Iterable<clientesModel> findAll();
   
    public Optional<clientesModel> findById(int id);
   
    public clientesModel save(clientesModel entity);
   
    public void deleteById(int id);
   
    Iterable<clientesModel> saveAll(Iterable<clientesModel> entities);

    
} 

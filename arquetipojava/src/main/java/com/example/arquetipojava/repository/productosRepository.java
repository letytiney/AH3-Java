package com.example.arquetipojava.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.arquetipojava.models.productosModel;

public interface productosRepository extends CrudRepository<productosModel, Object> {
    
}

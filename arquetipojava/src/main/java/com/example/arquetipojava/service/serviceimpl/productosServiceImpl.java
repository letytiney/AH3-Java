package com.example.arquetipojava.service.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.arquetipojava.common.CommonSvcImpl;
import com.example.arquetipojava.models.productosModel;
import com.example.arquetipojava.repository.productosRepository;
import com.example.arquetipojava.service.productoService;
@Service
public class productosServiceImpl extends CommonSvcImpl<productosModel, productosRepository> implements productoService{

    @Override
    public void deleteById(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public Iterable<productosModel> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<productosModel> findById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public productosModel save(productosModel entity) {
        return this.repository.save(entity);
    }

    @Override
    public Iterable<productosModel> saveAll(Iterable<productosModel> entities) {
        return this.repository.saveAll(entities);
    }
    
}

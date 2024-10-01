package com.example.arquetipojava.service;



import java.util.Optional;
import com.example.arquetipojava.common.CommonSvc;
import com.example.arquetipojava.models.productosModel;


public interface productoService extends CommonSvc<productosModel> {
    public Iterable<productosModel> findAll();

    public Optional<productosModel> findById(int id);
   
    public productosModel save(productosModel entity);
   
    public void deleteById(int id);
   
    Iterable<productosModel> saveAll(Iterable<productosModel> entities);

}

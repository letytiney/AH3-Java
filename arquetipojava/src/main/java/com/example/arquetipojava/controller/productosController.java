package com.example.arquetipojava.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.arquetipojava.models.clientesModel;
import com.example.arquetipojava.models.productosModel;
import com.example.arquetipojava.service.productoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/productos")
public class productosController {
    @Autowired
    private productoService productoService;

    @GetMapping("/listar")
    public Iterable<productosModel> getProductos()  {
        return this.productoService.findAll();
    }
    
      @PostMapping("/guardar")
    public ResponseEntity<String> saveProductos(@RequestBody productosModel entity) {
        try {
            this.productoService.save(entity);
            return ResponseEntity.ok("Producto guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }
    }

        @DeleteMapping("/eliminar/{idProducto}")
    public ResponseEntity<String> deleteClientes(@PathVariable int idProducto) {
        try {
            this.productoService.deleteById(idProducto);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }
    }
       @PutMapping("/actualizar/{idProducto}")
public ResponseEntity<String> updateProducto(@PathVariable int idProducto, @RequestBody productosModel entity) {
    try {
      
        Optional<productosModel> existingProducto = this.productoService.findById(idProducto);
        
        if (existingProducto.isPresent()) {
            productosModel productoToUpdate = existingProducto.get();
            
            productoToUpdate.setNombre(entity.getNombre());
            productoToUpdate.setPrecio(entity.getPrecio());
            productoToUpdate.setStock(entity.getStock());
            
            this.productoService.save(productoToUpdate);
            return ResponseEntity.ok().body("Producto actualizado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error al actualizar el Producto");
    }
}

}
